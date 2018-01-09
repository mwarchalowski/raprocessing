name := "raprocessing"
organization := "com.minimax"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "com.typesafe.play" %% "play-slick" %  "3.0.3"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3"
libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % "3.2.1"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.34"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.minimax.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.minimax.binders._
