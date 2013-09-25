import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {
    val appName         = "paypal-scala"
    val appVersion      = "0.1.0-SNAPSHOT"

    scalaVersion := "2.10.2"

    val appDependencies = Seq(
    	"com.micronautics" % "paypal" % "0.1.0" withSources()
    )
    val main = play.Project(appName, appVersion, appDependencies).settings(
      resolvers += Resolver.url("play-plugin-releases", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("play-plugin-snapshots", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots/"))(Resolver.ivyStylePatterns)
    )

}
