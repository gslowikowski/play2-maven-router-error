package test

import _root_.controllers.AssetsComponents
import module.one.OneComponents
import module.two.TwoComponents
import play.api.ApplicationLoader.Context
import play.api.{BuiltInComponentsFromContext, NoHttpFiltersComponents}
import router.Routes

class ApplicationComponents(
  context: Context
) extends BuiltInComponentsFromContext(
  context
) with NoHttpFiltersComponents
  with AssetsComponents {

  lazy val oneComponents = new OneComponents(httpErrorHandler, controllerComponents)
  lazy val twoComponents = new TwoComponents(httpErrorHandler, controllerComponents)

  override val router: Routes = new Routes(
    httpErrorHandler,
    oneComponents.router,
    twoComponents.router,
    assets
  )
}
