package test.controllers

import play.api.libs.json.Json
import play.api.mvc.{AbstractController, Action, ControllerComponents}

import scala.concurrent.ExecutionContext

class StatusController(
  controllerComponents: ControllerComponents
)(implicit val executionContext: ExecutionContext) extends AbstractController(controllerComponents) {
  def status(): Action[Unit] = Action(parse.empty) { _ =>
    Ok(Json.obj(
      "version" -> "1.0"
    ))
  }
}
