package utilities

import java.io.File

import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.{GetObjectRequest, ResponseHeaderOverrides, S3Object}
import com.amazonaws.services.s3.transfer.{TransferManager, Upload}

import scala.collection.JavaConversions._

/**
  * Created by lil on 6/21/16.
  */
object S3Access {

  val s3Client = new AmazonS3Client(awsCredential.getCredentials)

  def awsCredential = new ProfileCredentialsProvider

  def listFiles(bucketName: String): Unit = {
    val objectListing = s3Client.listObjects(bucketName)
    val objectSummaries = objectListing.getObjectSummaries.toList

    for (objSummary <- objectSummaries) {
      println(objSummary)
    }
  }

  def awsAccessKeyId(): String = {
    awsCredential.getCredentials.getAWSAccessKeyId
  }

  def awsAccessKey(): String = {
    awsCredential.getCredentials.getAWSSecretKey
  }

  /*
  @param bucketName
   */
  def getFile(bucketName:String, fileName:File, sFile:String):Unit= {

    val transfer = new TransferManager(awsCredential.getCredentials)
    val myUpload = transfer.upload(bucketName, awsCredential.getCredentials.getAWSSecretKey, fileName)


  }

  def main(args: Array[String]): Unit = {
    try{
      println(s3Client)
      listFiles("commonCrawl/crawl-data/CC-MAIN-2016-22")
//     S3Object object = s3Client.getObject(
//        new GetObjectRequest(bucketName, key));
//      InputStream objectData = object.getObjectContent();
//      getFile("azzurolilc",
//        "s3://commonCrawl/crawl-data/CC-MAIN-2016-22/segments/1464049275764.90/warc/CC-MAIN-20160524002115-00113-ip-10-185-217-139.ec2.internal.warc.gz",
//        "testSegment.warc.gz")
      //getFile("commonCrawl/crawl-data/CC-MAIN-2016-22", "crawl-data/CC-MAIN-2016-22/segments/1464049275764.90/warc/CC-MAIN-20160524002115-00113-ip-10-185-217-139.ec2.internal.warc.gz")
    } catch {
      case ex: Exception => println(ex)
    }

  }
}

