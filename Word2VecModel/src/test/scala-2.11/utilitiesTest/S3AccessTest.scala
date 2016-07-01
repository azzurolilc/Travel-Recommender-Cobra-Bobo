package utilitiesTest

import utilities.S3Access._
import org.scalatest._

/**
  * Created by lil on 6/21/16.
  */
class S3AccessTest extends FlatSpec with Matchers {


  /*
   * Check credential length
   */

  "A awsCredential" should "contain a key and an id" in{
    awsCredential.getCredentials.getAWSAccessKeyId.length should be (20)
    awsCredential.getCredentials.getAWSSecretKey.length should be (40)
  }





}
