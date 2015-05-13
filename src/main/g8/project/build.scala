import sbt._
import Keys._
import com.typesafe.sbt.packager.archetypes._
import com.typesafe.sbt.packager.universal._

object build extends Build {

  val gcsettings = Defaults.defaultSettings

  val gc = TaskKey[Unit]("gc", "runs garbage collector")
  val gcTask = gc := {
    println("requesting garbage collection")
    System gc()
  }

  lazy val project = Project (
    "project",
    file("."),
    settings = gcsettings ++ Seq(gcTask)
  ).enablePlugins(JavaAppPackaging, UniversalPlugin)
}
