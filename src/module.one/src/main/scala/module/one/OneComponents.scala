package module.one

import module.one.controllers.StatusController

import play.api.http.HttpErrorHandler
import play.api.mvc.ControllerComponents

import scala.concurrent.ExecutionContext

class OneComponents(
  httpErrorHandler: HttpErrorHandler,
  controllerComponents: ControllerComponents
)(implicit executionContext: ExecutionContext) {

  lazy val router: Routes = new Routes(
    httpErrorHandler,
    statusController
  )

  lazy val statusController: StatusController = new StatusController(controllerComponents)
}