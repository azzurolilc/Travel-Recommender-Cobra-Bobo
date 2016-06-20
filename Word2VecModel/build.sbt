name := "Word2VecModel"

version := "1.0"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

//scalaVersion := "2.10.6"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(

  //  "org.scala-lang" % "scala-reflect" % "2.10.6",
  //  "org.scala-lang" % "scala-compiler" % "2.10.6",
  "org.scala-lang" % "scala-reflect" % "2.11.8",
  "org.scala-lang" % "scala-compiler" % "2.11.8",

  "com.amazonaws" % "aws-java-sdk" % "1.11.7",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.7",

  "com.google.guava" % "guava" % "19.0",

  "org.apache.hadoop" % "hadoop-common" % "2.7.2",
  "org.apache.hadoop" % "hadoop-client" % "2.7.2",
  //    exclude("com.google.guava", "guava"),

  "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.4",
  //  "com.fasterxml.jackson.module" % "jackson-module-scala_2.10" % "2.7.4",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.7.4",


  //   Spark version 2.0-preview
  "org.apache.spark" % "spark-core_2.11" % "2.0.0-preview"
    exclude("com.fasterxml.jackson.core", "jackson-databind"),
  "org.apache.spark" % "spark-sql_2.11" % "2.0.0-preview"
    exclude("com.fasterxml.jackson.core", "jackson-databind"),
  "org.apache.spark" % "spark-mllib_2.11" % "2.0.0-preview"
    exclude("com.fasterxml.jackson.core", "jackson-databind"),
  "org.apache.spark" % "spark-streaming_2.11" % "2.0.0-preview"
    exclude("com.fasterxml.jackson.core", "jackson-databind"),

  "com.databricks" % "spark-csv_2.11" % "1.4.0"

//  "org.apache.spark" % "spark-core_2.11" % "1.6.1"
//    exclude("com.fasterxml.jackson.core", "jackson-databind"),
//  "org.apache.spark" % "spark-mllib_2.11" % "1.6.1"
//    exclude("com.fasterxml.jackson.core", "jackson-databind"),
//  "org.apache.spark" % "spark-streaming_2.11" % "1.6.1"
//    exclude("com.fasterxml.jackson.core", "jackson-databind"),

//  "org.deeplearning4j" % "dl4j-spark_2.11" % "0.4-rc3.10"
//    exclude("org.apache.spark", "spark-core_2.11"),
//  "org.deeplearning4j" % "dl4j-spark-nlp_2.11" % "0.4-rc3.10"
//    exclude("com.fasterxml.jackson.core", "jackson-databind"),
  //
  //  "org.deeplearning4j" % "deeplearning4j-core" % "0.4-rc3.10",
  //  "org.deeplearning4j" % "deeplearning4j-nlp" % "0.4-rc3.10",

  //  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0",
  //
  //  "org.apache.lucene" % "lucene-core" % "6.0.1",
  //  "org.apache.lucene" % "lucene-queryparser" % "6.0.1",
//
//  "org.apache.cassandra" % "cassandra-all" % "3.5"
//    exclude("org.slf4j", "log4j-over-slf4j")

  //  "org.specs2" % "specs2-core_2.11" % "3.8.3" % Test,
  //  "org.scalatest" % "scalatest_2.11" % "3.0.0-M16-SNAP6" % Test

)