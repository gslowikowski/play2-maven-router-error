lazy val root = (project in file("."))
  .settings(
    name := "static-function-call"
  )
  .aggregate(
    one,
    two,
    finale
  )

lazy val one = (project in file("./src/module.one"))
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .settings(Settings.scala.commonSettings)
  .settings(
    name := "module.one",
    routesImport := Seq.empty //Remove the default imports in the generated route file to avoid warnings
  )

lazy val two = (project in file("./src/module.two"))
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .settings(Settings.scala.commonSettings)
  .settings(
    name := "module.two",
    routesImport := Seq.empty //Remove the default imports in the generated route file to avoid warnings
  )

lazy val finale = (project in file("./module.finale"))
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .settings(Settings.scala.commonSettings)
  .settings(
    name := "module.finale",
    routesImport := Seq.empty //Remove the default imports in the generated route file to avoid warnings
  )
  .dependsOn(
    one,
    two
  )