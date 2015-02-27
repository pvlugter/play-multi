lazy val root = project
  .in(file("."))
  .aggregate(scalaModule, playModule)

lazy val scalaModule = project
  .in(file("scala-module"))
  .settings(commonSettings: _*)
  .settings(
    name := "scala-module",
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  )

lazy val playModule = project
  .in(file("play-module"))
  .enablePlugins(PlayScala)
  .dependsOn(scalaModule)
  .settings(commonSettings: _*)
  .settings(
    name := "play-module",
    libraryDependencies ++= Seq(jdbc, anorm, cache, ws)
  )

lazy val commonSettings = Seq(
  organization := "com.example",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.5"
)
