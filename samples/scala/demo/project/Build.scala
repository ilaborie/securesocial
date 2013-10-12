import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {
    val appName         = "ssdemo-scala"
    val appVersion      = "1.0"

    val appDependencies = Seq(
      "com.micronautics" %% "securesocial" % "2.1.1-SNAPSHOT" withSources
    )
    val main = play.Project(appName, appVersion, appDependencies).settings(
      scalaVersion := "2.10.3",

      resolvers ++= Seq(
        //Resolver.file("Local Repository", file(sys.env.get("PLAY21_HOME").map(_ + "/repository/local").getOrElse("")))(Resolver.ivyStylePatterns),
        Resolver.url("play-plugin-releases", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns),
        Resolver.url("play-plugin-snapshots", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots/"))(Resolver.ivyStylePatterns)
      ),
      scalacOptions ++= Seq("-deprecation", "-encoding", "UTF-8", "-feature", "-target:jvm-1.6", "-unchecked",
      "-Ywarn-adapted-args", "-Ywarn-value-discard", "-Xlint"),
      logBuffered in Test := false,
      Keys.fork in Test := false,
      parallelExecution in Test := false
    )
}
