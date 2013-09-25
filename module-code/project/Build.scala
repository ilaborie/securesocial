import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {
  val appName         = "securesocial"
  val appVersion      = "2.2.0"

  scalaVersion := "2.10.2"

  val appDependencies = Seq(
    cache,
    "com.typesafe.play"    %% "play-json"           % "2.2.0",
    "org.codehaus.jackson" %  "jackson-mapper-asl"  % "1.9.11",
    "com.typesafe"         %% "play-plugins-util"   % "2.1.0",
    "com.typesafe"         %% "play-plugins-mailer" % "2.1.0",
    "org.mindrot"          %  "jbcrypt"             % "0.3m"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    organization  := "com.micronautics", // Don't want this fork to step on securesocial
    crossPaths    := false,
    publishMavenStyle := false,
    resolvers ++= Seq(
      "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",
      "Typesafe Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
    ),
    publishTo <<= (version) { version: String =>
       val scalasbt = "http://repo.scala-sbt.org/scalasbt/"
       val (name, url) = if (version.contains("-SNAPSHOT"))
         ("sbt-plugin-snapshots", scalasbt+"sbt-plugin-snapshots")
       else
         ("sbt-plugin-releases", scalasbt+"sbt-plugin-releases")
       Some(Resolver.url(name, new URL(url))(Resolver.ivyStylePatterns))
    }
  )
}

