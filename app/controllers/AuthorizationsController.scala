package controllers
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import services.AuthorizationService
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton
class AuthorizationsController @Inject() (
                                 cc: ControllerComponents,
                                 authService: AuthorizationService
                               )(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def post() = Action.async(parse.json) { request: Request[JsValue] =>
    val f = authService.initiate((request.body \ "email").as[String])
    f.map( ra => Ok(Json.toJson(ra)))
  }

  def single(id: String) = Action.async {
    authService.find(id).map(ra => Ok(Json.toJson(ra)))
  }

  def all() = Action.async {
    authService.findAll.map(ras => Ok(Json.toJson(ras)))
  }
}
