package africa.absa

/**
 * @author ${user.name}
 */
import africa.absa.utils.ConfigFileManager
import org.apache.spark.sql.SparkSession

object App {
  

  def main(args : Array[String]) {

    //config test
    println(ConfigFileManager.getConfig("my.config"))

    val spark = SparkSession.builder().master("local").getOrCreate()

    import spark.implicits._

    val df = spark.sparkContext.parallelize(Seq((1,2,3))).toDF

    df.show

  }

}
