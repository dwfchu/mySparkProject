package africa.absa.utils

import java.io.File

import com.typesafe.config.ConfigFactory

object ConfigFileManager {

  //create config load embedded settings
  private val baseConf = ConfigFactory.load()

  //read overrride external file
  private val externalConf = ConfigFactory.parseFile(new File("application.conf"))

  //set order of precendance
  private val settings = externalConf.withFallback(baseConf)

  def getConfig(key: String): String = {
    settings.getString(key)
  }
}
