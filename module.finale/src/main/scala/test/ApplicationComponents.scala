package test

import play.api.ApplicationLoader.Context
import play.api.{BuiltInComponentsFromContext, NoHttpFiltersComponents}
import test.intern.{Routes => InternRoutes}
import test.controllers.StatusController

class ApplicationComponents(
  context: Context
) extends BuiltInComponentsFromContext(
  context
) with NoHttpFiltersComponents {

  val statusController: StatusController = new StatusController(controllerComponents)

  val testRouter: InternRoutes = new InternRoutes(
    httpErrorHandler,
    statusController
  )

  override val router: Routes = new Routes(
    httpErrorHandler,
    testRouter,
    statusController
  )
}
