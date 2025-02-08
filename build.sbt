name := "emrtd_manager"

version := "0.1"

scalaVersion := "2.13.10"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.10" % Test,
  "com.typesafe.akka" %% "akka-actor-typed" % "2.6.18"
)

ThisBuild / organization := "com.koke1997"
