
resolvers += "OASVC Artifactory" at "https://itvrepos.jfrog.io/itvrepos/hubsvc-ivy"

credentials += Credentials(credentialsLocation.asFile)
val credentialsLocation: RichFile =
 sys.props.get(“credentials.location”).map(Path(_)).getOrElse(Path.userHome / “.ivy2" / “.credentials”)

addSbtPlugin("com.itv.chuckwagon" % "sbt-chuckwagon" % "0.1.4-SNAPSHOT")
