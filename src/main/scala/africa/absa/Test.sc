import africa.absa.utils.ConfigFileManager

ConfigFileManager.getConfig("my.config")

//neg test

ConfigFileManager.getConfig("my.config.doesn't exist")