package africa.absa

/**
  * @author ${user.name}
  */

import africa.absa.utils.ConfigFileManager
import org.apache.spark.sql.SparkSession

object App {


  def main(args: Array[String]) {

    //config test
    println(ConfigFileManager.getConfig("my.config"))
    println("test")

    val spark = SparkSession.builder()
      //remove to run on cluster
      .master("local")
      //i needed this as zscaler is messing with my ip routing
      .config("spark.driver.bindAddress", "127.0.0.1")
      .getOrCreate()

    import spark.implicits._

    val df = spark.sparkContext.parallelize(Seq((1, 2, 3))).toDF

    df.show

  }

}
