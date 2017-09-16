name := """lib-project"""
organization := "com.project"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(guice,
                            evolutions,
                            javaJdbc,
                            "mysql" % "mysql-connector-java" % "5.1.41")

