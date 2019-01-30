resolvers += "OASVC Artifactory" at "https://itvrepos.jfrog.io/itvrepos/hubsvc-ivy"

  name := "simpleLambda"
  version := "0.1"
  scalaVersion := "2.12.8"
  chuckRegion := "eu-west-1"

credentials += Credentials(credentialsLocation.asFile)
val credentialsLocation: RichFile =
 sys.props.get(“credentials.location”).map(Path(_)).getOrElse(Path.userHome / “.ivy2" / “.credentials”)


libraryDependencies ++= Seq(
  "com.itv.chuckwagon" %% "chuckwagon-jvm" % "0.1.4-SNAPSHOT"
)

chuckPublishConfig := chuckPublishConfigBuilder
  .withName("Simple-Lambda")
  .withHandler("HelloWorld::handleRequest")
  .withMemorySizeInMB(192)
  .withTimeout("5 seconds")
  .withStagingBucketName("simple-lambda")
  .withCodeFile(assembly)
  .withRoleARN("arn:aws:iam::586133794935:role/dev_iam_profile_lambda_execute-default_role")

  enablePlugins(ChuckwagonPublishPlugin)
