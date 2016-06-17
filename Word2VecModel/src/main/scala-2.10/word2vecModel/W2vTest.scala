package word2vecModel

//import org.apache.spark.SPARK_VERSION
//import org.apache.spark.rdd._
import org.apache.spark.mllib.feature.{Normalizer, Word2VecModel}
import org.apache.spark.mllib.linalg.DenseVector
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by lil on 6/15/16.
  */
object W2vTest {
//  val normalizer = new Normalizer()
//  val model = new Word2VecModel()
//  var king = ???
//
//  def dotProduct(v1: Array[Float], v2: Array[Float]) = {
//    v1.zip(v2).map { case (e1, e2) => e1 * e2 }.sum
//  }
//
//  def diff(v1: Array[Float], v2: Array[Float]) = {
//    v1.zip(v2).map { case (e1, e2) => e1 - e2 }
//  }
//
//  def add(v1: Array[Float], v2: Array[Float]) = {
//    v1.zip(v2).map { case (e1, e2) => e1 + e2 }
//  }
//
//  def normalize(v: Array[Float]) = {
//    val m = magnitude(v);
//    v.map(_ / m)
//  }
//
//  def magnitude(v: Array[Float]) = {
//    math.sqrt(v.map(e => {
//      e * e
//    }).sum)
//  }
//
//  def normalize(vector: Array[Float]) = {
//    val denseVector = new DenseVector(king.map(_.toDouble))
//    normalizer.transform(denseVector).toArray.map(_.toFloat)
//  }
//
//  def wordToVector(model: Word2VecModel, word: String) = {
//    val vectorMap = model.getVectors
//    val vectorSize = vectorMap.head._2.size
//    val vectorZero = Array.fill[Float](vectorSize)(0)
//    vectorMap.get(word).getOrElse(vectorZero)
//  }
//
//
//  wordToVector(model, "microsoft")
//  wordToVector(model, "happy")

  //
  //  // Get vectors
  //  val king = wordToVector(model,"king")
  //  val man = wordToVector(model,"man")
  //  val queen = wordToVector(model,"queen")
  //
  //  val kingMinusMan = diff(king,man)
  //  val kingMinusQueen = diff(king,queen)
  //
  //  // Find closest vector to diff
  //  model.getVectors.toSeq.
  //    map{case(word,vector)=>(word,dotProduct(vector,kingMinusMan))}.
  //    sortBy{case(word,dot)=>(-dot)}.
  //    take(40).
  //    foreach(println)

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("W2vTest").setMaster("local[*]").set("spark.ui.port", "18080")
    val sc = new SparkContext(conf)


    sc.parallelize(1 to 9).foreach(println)

    sc.wholeTextFiles("./data/Shakespeare/*").foreach(a => println(a._1))
    //        .map { case (file, text) => (file.replaceAll(".*/", ""), text) }
    //        .flatMapValues { text => text.toLowerCase.split("\\W+") }
    //        .map { case (file, word) => ((file, word), 1) }
    //        .reduceByKey(_ + _)
    //        .map { case ((file, word), count) => (word, (file, count)) }
    //        .groupByKey
    //        .map { case (word, iter) => (word,
    //          iter.toList.
    //            sortBy { case (file, count) => (-count) })
    //        }
    //        .collect.toMap.foreach(println)
  }
}
