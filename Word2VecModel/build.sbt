name := "Word2VecModel"

version := "0.1"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(

  //  "org.scala-lang" % "scala-reflect" % "2.10.6",
  //  "org.scala-lang" % "scala-compiler" % "2.10.6",
  "org.scala-lang" % "scala-reflect" % "2.11.8",
  "org.scala-lang" % "scala-compiler" % "2.11.8",
  "org.scalatest" % "scalatest_2.11" % "2.2.6",

  // Resolve conflicts
  "com.google.guava" % "guava" % "18.0",
  "jline" % "jline" % "2.12.1",
  //  "org.slf4j" % "slf4j-log4j12" % "1.7.21",

  "commons-io" % "commons-io" % "2.5",

  "com.amazonaws" % "aws-java-sdk" % "1.11.12",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.12",

  "org.apache.hadoop" % "hadoop-aws" % "2.7.2",
  "org.apache.hadoop" % "hadoop-common" % "2.7.2"
    exclude("com.google.guava", "guava"),
  "org.apache.hadoop" % "hadoop-client" % "2.7.2"
    exclude("com.google.guava", "guava"),

  "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.4",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.7.4",

  "org.apache.spark" % "spark-core_2.11" % "1.6.1"
    exclude("com.fasterxml.jackson.core", "jackson-databind"),

  "org.apache.spark" % "spark-hive_2.11" % "1.6.1",
  "org.apache.spark" % "spark-sql_2.11" % "1.6.1"
    exclude("com.fasterxml.jackson.core", "jackson-databind"),
  "org.apache.spark" % "spark-mllib_2.11" % "1.6.1"
    exclude("com.fasterxml.jackson.core", "jackson-databind"),
  "org.apache.spark" % "spark-streaming_2.11" % "1.6.1"
    exclude("com.fasterxml.jackson.core", "jackson-databind"),

  "com.databricks" % "spark-csv_2.11" % "1.4.0",
  "com.databricks" % "spark-avro_2.11" % "2.0.1",


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
  "org.apache.cassandra" % "cassandra-all" % "3.7"
    exclude("org.slf4j", "log4j-over-slf4j")
    exclude("log4j", "log4j"),

  "org.apache.kafka" % "kafka_2.11" % "0.10.0.0"

  //  "org.specs2" % "specs2-core_2.11" % "3.8.3" % Test,
  //  "org.scalatest" % "scalatest_2.11" % "3.0.0-M16-SNAP6" % Test

)