name := "cbPlayGround"

version := "0.0.1"

lazy val `cbplayground` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
//  "org.specs2" % "specs2_2.9.1" % "1.8",
"org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"


//scalaVersion := "2.11.7"
//
//libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.21"
//
//libraryDependencies ++= Seq( jdbc , cache , ws    )
//
//
//unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )
//
//resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"