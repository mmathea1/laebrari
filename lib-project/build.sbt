import play.sbt.PlayJava

name := """lib-project"""
organization := "com.project"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += jdbc
libraryDependencies += javaJdbc

libraryDependencies += evolutions

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"

