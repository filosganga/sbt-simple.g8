import sbt._

object Dependencies {

	val scalaArm = "com.jsuereth" %% "scala-arm" % "1.4"
	val scalaTest = "org.scalatest" %% "scalatest" % "2.2.4"
	val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.12.2"
	val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"

	val scopt = "com.github.scopt" %% "scopt" % "3.3.0"

	object typesafe {

		val config = "com.typesafe" % "config" % "1.3.0"
	}

	object slf4j {
		val api = "org.slf4j" % "slf4j-api" % "1.7.12"
	}

	object mockito {
		val core = "org.mockito" % "mockito-core" % "1.10.19"
		val all = "org.mockito" % "mockito-all" % "1.10.19"
	}

	object scalaz {

		private val version = "7.1.2"

		val core = "org.scalaz" %% "scalaz-core" % version
	}

	object akka {

		private val version = "2.3.10"

		val actor = "com.typesafe.akka" %% "akka-actor" % version
		val cluster = "com.typesafe.akka" %% "akka-cluster" % version
		val slf4j = "com.typesafe.akka" %% "akka-slf4j" % version
		val contrib = "com.typesafe.akka" %% "akka-contrib" % version
		val persistence = "com.typesafe.akka" %% "akka-persistence-experimental" % version
		val testKit = "com.typesafe.akka" %% "akka-testkit" % version
	}

	object spray {

		private val version = "1.3.3"

		val can = "io.spray" %% "spray-can" % version
		val http = "io.spray" %% "spray-http" % version
		val httpx = "io.spray" %% "spray-httpx" % version
		val client = "io.spray" %% "spray-client" % version
		
	}

	object json4s {

		private val version = "3.2.11"

		val core = "org.json4s" %% "json4s-core" % version
		val native = "org.json4s" %% "json4s-native" % version
    val ext = "org.json4s" %% "json4s-ext" % version
	}

	object joda {

		val nScalaTime = "com.github.nscala-time" %% "nscala-time" % "2.0.0"
		val time = "joda-time" % "joda-time" % "2.7"
		val convert = "org.joda" % "joda-convert" % "1.7"
	}

  object play {
    val json = "com.typesafe.play" %% "play-json" % "2.3.8"
  }

}