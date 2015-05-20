lazy val ScalaDebuggerAkka = project
  .in(file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)
  .settings(
    name := "scala-debugger-akka",

    version := "1.0.0",

    organization := "com.senkbeil",

    licenses += (
      "Apache-2.0",
      url("https://www.apache.org/licenses/LICENSE-2.0.html")
    ),

    // Default version when not cross-compiling
    scalaVersion := "2.10.5",

    crossScalaVersions := Seq("2.10.5", "2.11.6"),

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

    libraryDependencies ++= Seq(
      "com.senkbeil" %% "debugger-api" % "1.0.0",
      "com.typesafe.akka" %% "akka-actor" % "2.3.11",
      "org.scalatest" %% "scalatest" % "2.2.1" % "test,it",
      "org.scalamock" %% "scalamock-scalatest-support" % "3.2.1" % "test,it",
      "com.typesafe.akka" %% "akka-testkit" % "2.3.11" % "test,it"
    )
  )
