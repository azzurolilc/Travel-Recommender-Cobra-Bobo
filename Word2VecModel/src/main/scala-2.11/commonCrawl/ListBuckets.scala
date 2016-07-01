package commonCrawl

import java.io.FileWriter

import check.Checks
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.immutable.TreeMap
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by lil on 6/19/16.
  */

/*
 *
 * Get metadata for domains: tripadvisor.com
 */

object ListBuckets {

  private final val domains = List("travbuddy.com", "tripadvisor.com", "lonelyplanet.com", "ordinarytraveler.com", "wanderingearl.com")

  /*
   *
   * List all buckets from meta
   *
   */


  def main(args: Array[String]): Unit = {

    metadata()

  }

  def metadata() = {
    val conf = new SparkConf()
      .setAppName("StoreDataSourceTable")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)
    val sQLContext = new SQLContext(sc)

    domains.foreach(d => {
      val dm = new DomainMeta(d)

      printf("%s -- pages: %s, blocks: %s, pageSize: %s\n", d, dm.pages, dm.blocks, dm.pageSize)

      val ld = new ListDomainBuckets(dm)

      ld.saveAllPages()
      println(ld.fileList.toString)

      sQLContext.read.json("data/cc").foreach(println)
      ld.fileList.foreach(fileName => {
//        val sqlContext = new HiveContext(sc)
//        val df = sqlContext.read.json(fileName).foreach(println)

      })
    })
  }

  class DomainMeta(url: String) {

    val domain = url
    val pages = dataTree.getOrElse("pages", 0)
    val blocks = dataTree.getOrElse("blocks", 0)
    val pageSize = dataTree.getOrElse("pageSize", 0)
    private val metaUrl = "http://index.commoncrawl.org/CC-MAIN-2016-22-index?url=*.%s&output=json&showNumPages=true".format(domain)
    private val dataTree = getMetaData()

    def getMetaData(): TreeMap[String, Int] = {
      var map = TreeMap.empty[String, Int]

      //{"blocks": Int, "pages": Int, "pageSize": Int}
      val pattern =
        """^\{\"(\w*)\":\s?(\d*),\s?\"(\w*)\":\s?(\d*),\s?\"(\w*)\":\s?(\d*)\}$""".r

      try {
        val html = Source
          .fromURL(metaUrl)
          .mkString
        println(" " + html)

        pattern.findAllMatchIn(html).foreach(m => {
          map += (m.group(1).toString -> m.group(2).toInt)
          map += (m.group(3).toString -> m.group(4).toInt)
          map += (m.group(5).toString -> m.group(6).toInt)
        })
      }
      catch {
        case ex: Exception => println(metaUrl + " " + ex)
      }
      map
    }

  }

  class ListDomainBuckets(domainMeta: DomainMeta) {


    var count = 0
    var fileList = new ListBuffer[String]

    def saveAllPages() = {
      for (pageNum <- 0 until domainMeta.pages) {
        count += 1
        val pageUrl = "http://index.commoncrawl.org/CC-MAIN-2016-22-index?url=*.%s&output=json&page=%s".format(domainMeta.domain, pageNum)
        fileList += saveJson(pageNum, pageUrl)
      }
    }

    def saveJson(num: Int, url: String): String = {
      val fileName = "data/cc/%s_%d.json".format(domainMeta.domain.substring(0, domainMeta.domain.indexOf('.')), num)
      val fw = new FileWriter(fileName, false)
      fw.write(readPage(url))
      fw.close()
      fileName
    }

    private def readPage(pageUrl: String): String = {
      val pageContent = Source
        .fromURL(pageUrl)
        .mkString
      //    print(pageContent)
      pageContent
    }
  }

}