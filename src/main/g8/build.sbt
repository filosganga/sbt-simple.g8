import Dependencies._

name := "$name;format="norm"$"
organization := "$project_group_id$"
// description := "this project can foo a bar!"

homepage := Some(url("$project_homepage$"))
startYear := Some(2015)

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

/* scala versions and options */
scalaVersion := "2.11.6"
crossScalaVersions := Seq(
  "2.10.5"
)

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-encoding", "UTF-8",
  // "-Xcheckinit" // for debugging only, see https://github.com/paulp/scala-faq/wiki/Initialization-Order
  // "-optimise"   // this option will slow your build
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


mainClass := Some("$project_group_id$.$name;format="snake"$.Main")

/* dependencies */
libraryDependencies ++= Seq (
  // -- lang --
  scalaArm,
  joda.nScalaTime,
  joda.time,
  joda.convert,
  // -- util --
  scopt,
  scalaLogging,
  slf4j.api,
  typesafe.config,
  // -- Testing --
  scalaTest % "test",
  scalaCheck % "test",
  mockito.core % "test"
)

/* you may need these repos */
resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.typesafeRepo("release")
)

/* publishing */
publishMavenStyle := true
publishTo :=  Some("$publish_repository_name$" at "$publish_repository_url$$name;format="norm"$")

mappings in (Compile, packageBin) ~= { (ms: Seq[(File, String)]) =>
  ms filter { case (file, toPath) =>
      toPath != "application.conf"
  }
}

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
