package test

import _root_.controllers.AssetsComponents
import controllers.HomeController
import play.api.ApplicationLoader.Context
import play.api.db.evolutions.EvolutionsComponents
import play.api.db.{DBComponents, HikariCPComponents}
import play.api.{BuiltInComponentsFromContext, NoHttpFiltersComponents}

class ApplicationComponents(
  context: Context
) extends BuiltInComponentsFromContext(
  context
) with NoHttpFiltersComponents
  with AssetsComponents
  with DBComponents
  with HikariCPComponents
  with EvolutionsComponents {

  applicationEvolutions //side effect to launch the db evolutions

  lazy val oneComponents = new OneComponents(httpErrorHandler, controllerComponents)
  lazy val twoComponents = new TwoComponents(httpErrorHandler, controllerComponents)

  override val router: _root_.router.Routes = new _root_.router.Routes(
    httpErrorHandler,
    oneComponents.router,
    twoComponents.router,
    homeController,
    assets
  )
  lazy val homeController: HomeController = new HomeController(controllerComponents)
}
