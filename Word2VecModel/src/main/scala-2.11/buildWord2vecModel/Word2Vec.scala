//package buildWord2vecModel
//
//import org.apache.spark.ml.feature.Word2Vec
//import org.apache.spark.sql.SparkSession
//import org.apache.spark.{SparkConf, SparkContext}
//
///**
//  * Created by lil on 6/15/16.
//  */
//
//object Word2Vec {
//
//
//  def main(args:Array[String]): Unit ={
//
//    val conf = new SparkConf().setAppName("Word2VecModel").setMaster("local[*]")
//
//    val sc = new SparkContext(conf)
//
//    val windowSize = 7
//    val minCount = 5
//
//
////    val sc = new SparkContext(conf)
////    val sqlContext = new SQLContext(sc)
////    val sampleData: Seq[ScalaPerson] = ScalaData.sampleData()
////    val dataset = sqlContext.createDataset(sampleData)
//
//    val sparkSession = new SparkSession()
//
////
////    val input = sc.wholeTextFiles("./data/Shakespeare/*")
////      .map(text=> text.toString().split("\\W+").filter(_.length > 0).toSeq)
//
//    val data = sparkSession.read.text("./data/Shakespeare/*").as[String]
//
//    val words = data.flatMap(_.split(" ")).filter(_ != "")
//
//    val word2vec = new Word2Vec()
//
//    val model = word2vec.setWindowSize(windowSize)
//      .setMinCount(minCount)
//      .setSeed(42L)
//      .fit(words)
//
//    model.save("myModel")
////
////    val sameModel = Word2VecModel.load(sc, "myModelPath")
////
////    // Make sure the model is the same
////    sameModel.findSynonyms("king", 40).foreach(println)
//
//
//
//
//  }
//}
