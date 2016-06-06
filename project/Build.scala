import sbt.Keys._
import sbt._

object SBTTemplateBuild extends Build {
  val versionNumber = "1.0.0"

  lazy val buildSettings = Defaults.coreDefaultSettings ++ Seq(
    organization := "amozh",
    scalaVersion := "2.11.8"
  )

  lazy val root = Project(
    id = "sbt-template-root",
    base = file("."),
    aggregate = Seq(
      specificPrj
    ),
    settings = buildSettings ++ Seq(
      //Some common settings
    )
  )

  lazy val specificPrj = Project(
    id = "specific-prj",
    base = file("specific-prj"),
    settings = buildSettings ++ Seq(
      libraryDependencies ++= Dependencies.specificPrj
    )
  )
}

object Dependencies {

  object V {
    val scalatest = "2.2.4"
    val sl4j = "2.1.2"
    val mickito = "1.10.19"
  }

  val common = Seq(
    "com.typesafe.scala-logging" %% "scala-logging-slf4j" % V.sl4j
      exclude("org.slf4j", "slf4j-api") exclude("org.scala-lang", "scala-library")
  )

  val testing = Seq(
    "org.scalatest" %% "scalatest" % V.scalatest % "test" exclude("org.scala-lang", "scala-library"),
    "org.mockito" % "mockito-core" % V.mickito % "test"
  )

  val specificPrj = common ++ testing
}
