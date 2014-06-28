/* basic project info */
name := "$name;format="norm"$"

organization := "$project_group_id$"

version := "1.0-SNAPSHOT"

// description := "this project can foo a bar!"

homepage := Some(url("https://github.com/$github_username$/$name;format="norm"$"))

startYear := Some(2014)

licenses := Seq(
  ("$project_license_name$", url("$project_license_url$"))
)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/$github_username$/$name;format="norm"$"),
    "scm:git:https://github.com/$github_username$/$name;format="norm"$.git",
    Some("scm:git:git@github.com:$github_username$/$name;format="norm"$.git")
  )
)

// organizationName := "My Company"

/* scala versions and options */
scalaVersion := "2.10.4"

crossScalaVersions := Seq(
  "2.9.3"
)

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-encoding", "UTF-8"
  // "-Xcheckinit" // for debugging only, see https://github.com/paulp/scala-faq/wiki/Initialization-Order
  // "-optimise"   // this option will slow your build
)

scalacOptions ++= Seq(
  "-Yclosure-elim",
  "-Yinline"
)

// These language flags will be used only for 2.10.x.
// Uncomment those you need, or if you hate SIP-18, all of them.
scalacOptions <++= scalaVersion map { sv =>
  if (sv startsWith "2.11") List(
    "-Xverify",
    "-feature"
  )
  else if (sv startsWith "2.10") List(
    "-Xverify",
    "-Ywarn-all",
    "-feature"
    // "-language:postfixOps",
    // "-language:reflectiveCalls",
    // "-language:implicitConversions"
    // "-language:higherKinds",
    // "-language:existentials",
    // "-language:experimental.macros",
    // "-language:experimental.dynamics"
  )
  else Nil
}

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* entry point */
mainClass in (Compile, packageBin) := Some("$project_group_id$.$name;format="snake"$.Main")

mainClass in (Compile, run) := Some("$project_group_id$.$name;format="snake"$.Main")

// CONTINUATIONS
// autoCompilerPlugins := true
// addCompilerPlugin("org.scala-lang.plugins" % "continuations" % "2.9.2")
// scalacOptions += "-P:continuations:enable"

/* dependencies */
libraryDependencies ++= Seq (
  // -- lang --
  "com.github.nscala-time" %% "nscala-time" % "1.2.0",
  "com.jsuereth" %% "scala-arm" % "1.4",  
  // "com.google.guava" % "guava" % "16.0.1",
  // -- util --
  "com.github.scopt" %% "scopt" % "3.2.0",
  // -- logging & configuration --
  "com.typesafe" % "config" % "1.2.1",
  "org.slf4j" % "slf4j-api" % "1.7.7",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "3.0.0",
  // -- Testing --
  "org.scalatest" %% "scalatest" % "2.2.0" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.4" % "test",
  "org.mockito" % "mockito-all" % "1.9.5" % "test"
)

/* you may need these repos */
resolvers ++= Seq(
  Resolver.typesafeRepo("releases")
)

/* testing */
parallelExecution in Test := false

// testOptions += Tests.Argument(TestFrameworks.Specs2, "console", "junitxml")

// parallelExecution in Global := false //no parallelism between subprojects

/* sbt behavior */
logLevel in compile := Level.Warn

traceLevel := 5

offline := false

/* publishing */
publishMavenStyle := true

publishTo :=  Some("bintray-filosganga" at "https://api.bintray.com/maven/filosganga/maven/$name;format="norm"$")

mappings in (Compile, packageBin) ~= { (ms: Seq[(File, String)]) =>
  ms filter { case (file, toPath) =>
      toPath != "application.conf"
  }
}

publishArtifact in Test := false

// publishArtifact in (Compile, packageDoc) := false

// publishArtifact in (Compile, packageSrc) := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <developers>
    <developer>
      <id>$github_username$</id>
      <name>$developer_full_name$</name>
      <email>$developer_email$</email>
      <url>$developer_url$</url>
    </developer>
  </developers>
)

/* assembly plugin */
mainClass in AssemblyKeys.assembly := Some("$project_group_id$.$name;format="snake"$.Main")

assemblySettings

test in AssemblyKeys.assembly := {}
