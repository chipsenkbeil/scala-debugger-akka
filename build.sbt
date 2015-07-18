lazy val ScalaDebuggerAkka = project
  .in(file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)
  .settings(
    name := "scala-debugger-akka",

    version := "1.0.0",

    organization := "org.senkbeil",

    licenses += (
      "Apache-2.0",
      url("https://www.apache.org/licenses/LICENSE-2.0.html")
    ),

    homepage := Some(url("http://www.senkbeil.org/")),

    // Default version when not cross-compiling
    scalaVersion := "2.10.5",

    crossScalaVersions := Seq("2.10.5", "2.11.6"),

    libraryDependencies ++= Seq(
      // TODO: Figure out why IntelliJ keeps inserting scala-reflect 2.10.4
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.senkbeil" %% "scala-debugger-api" % "1.0.0",
      "com.typesafe.akka" %% "akka-actor" % "2.3.11",
      "org.scalatest" %% "scalatest" % "2.2.1" % "test,it",
      "org.scalamock" %% "scalamock-scalatest-support" % "3.2.1" % "test,it",
      "com.typesafe.akka" %% "akka-testkit" % "2.3.11" % "test,it"
    ),

    // JDK Dependency (just for sbt, must exist on classpath for execution,
    // cannot be redistributed)
    internalDependencyClasspath in Compile +=
      { Attributed.blank(Build.JavaTools) },
    internalDependencyClasspath in Runtime +=
      { Attributed.blank(Build.JavaTools) },
    internalDependencyClasspath in Test +=
      { Attributed.blank(Build.JavaTools) },
    internalDependencyClasspath in IntegrationTest +=
      { Attributed.blank(Build.JavaTools) },

    scalacOptions ++= Seq(
      "-encoding", "UTF-8", "-target:jvm-1.6",
      "-deprecation", "-unchecked", "-feature",
      "-Xfatal-warnings"
    ) ++ (CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, scalaMajor)) if scalaMajor == 10 => Seq("-Ywarn-all")
      case _ => Nil
    }),

    javacOptions ++= Seq(
      "-source", "1.6", "-target", "1.6", "-Xlint:all", "-Werror",
      "-Xlint:-options", "-Xlint:-path", "-Xlint:-processing"
    ),

    testOptions in Test += Tests.Argument("-oDF"),

    // Properly handle Scaladoc mappings
    autoAPIMappings := true,

    // Prevent publishing test artifacts
    publishArtifact in Test := false,

    publishMavenStyle := true,

    pomExtra := (
      <scm>
        <url>git@github.com:rcsenkbeil/scala-debugger-akka.git</url>
        <connection>scm:git:git@github.com:rcsenkbeil/scala-debugger-akka.git</connection>
      </scm>
      <developers>
        <developer>
          <id>senkwich</id>
          <name>Chip Senkbeil</name>
          <url>http://www.senkbeil.org</url>
        </developer>
      </developers>
    ),

    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    }
  )
