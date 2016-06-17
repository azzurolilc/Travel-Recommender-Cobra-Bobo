name := "Word2VecModel"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-java-sdk" % "1.11.7",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.7",

  "org.apache.spark" % "spark-mllib_2.11" % "1.6.1",
  "org.apache.spark" % "spark-core_2.11" % "1.6.1",

  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0",

  "org.apache.lucene" % "lucene-core" % "6.0.1",
  "org.apache.lucene" % "lucene-queryparser" % "6.0.1"
)