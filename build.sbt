import Dependencies._

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.github.logc"
ThisBuild / organizationName := "logc"

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "sbt-hello"
  )
