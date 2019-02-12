
ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "ie.solaire"

lazy val hello = (project in file("."))
  .settings(
    name := "Week 1",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  )
