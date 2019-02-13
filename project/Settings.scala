import sbt._
import Keys._
import play.sbt.routes.RoutesKeys

object Settings {

  object scala {
    val commonSettings = Seq(
      scalaVersion := "2.12.8",
      scalacOptions := Seq (
        "-Ywarn-value-discard",
        "-Ypartial-unification",
        "-Ywarn-unused",
        "-Xfatal-warnings",
        "-deprecation",
        "-unchecked",
        "-feature",
        "-Xlint"
      )
    )
  }
}
