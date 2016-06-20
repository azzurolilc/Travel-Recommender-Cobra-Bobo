package commonCrawl

import scala.collection.immutable.TreeMap
import scala.io.Source

/**
  * Created by lil on 6/19/16.
  */

/*
Get url: tripadvisor.com
 */

class DomainMeta(url: String) {

  val domain = url

  private val metaUrl = "http://index.commoncrawl.org/CC-MAIN-2016-22-index?url=*." + domain + "&output=json&showNumPages=true"
  private val dataTree = getMetaData()

  val pages = dataTree.getOrElse("pages", 0)
  val blocks = dataTree.getOrElse("blocks", 0)
  val pageSize = dataTree.getOrElse("pageSize", 0)

  def getMetaData(): TreeMap[String, Int] = {
    var map = TreeMap.empty[String, Int]

    //{"blocks": 68, "pages": 14, "pageSize": 5}
    val pattern =
      """^\{\"(\w*)\":\s?(\d*),\s?\"(\w*)\":\s?(\d*),\s?\"(\w*)\":\s?(\d*)\}$""".r

    try {
      val html = Source
        .fromURL(metaUrl)
        .mkString
      println("meta: "+html)
      pattern.findAllMatchIn(html).foreach(m => {
        map += (m.group(1).toString -> m.group(2).toInt)
        map += (m.group(3).toString -> m.group(4).toInt)
        map += (m.group(5).toString -> m.group(6).toInt)
      })
    }

    catch {
      case ex: Exception => println(ex)
    }
    map
  }

}

class ListDomainBuckets(domainMeta: DomainMeta) {

  def readPage(pageUrl:String):String = {
    val pageContent = Source
      .fromURL(pageUrl)
      .mkString
    print(pageContent)
    pageContent
  }


  def allPages() = {
    for (pageNum <- 0 to domainMeta.pages-1) {

      val pageUrl = "http://index.commoncrawl.org/CC-MAIN-2016-22-index?url=*." +
        domainMeta.domain + "&output=json/&page=" + pageNum

      readPage(pageUrl)

    }
  }
}

object someMain {

  def main(args: Array[String]): Unit = {

    //    val ls = new ListBucket()
    val travbuddy = new DomainMeta("travbuddy.com")
    println(travbuddy.pages)
    val listTa = new ListDomainBuckets(travbuddy)
    listTa.allPages()

  }

}