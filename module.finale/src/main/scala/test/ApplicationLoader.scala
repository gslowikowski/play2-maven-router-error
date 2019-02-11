package test

import play.api.ApplicationLoader.Context
import play.api.{Application, LoggerConfigurator}

class ApplicationLoader extends play.api.ApplicationLoader {
  def load(context: Context): Application = {
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment)
    }
    new ApplicationComponents(context).application
  }
}
