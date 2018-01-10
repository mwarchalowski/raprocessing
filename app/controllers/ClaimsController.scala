package controllers

import java.time.format.DateTimeFormatter

import com.google.inject.{Inject, Singleton}
import play.api.mvc._
import play.api.libs.json._
import models.Claim

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ClaimsController @Inject() (cc: ControllerComponents)(implicit val ec: ExecutionContext) extends AbstractController(cc) {


  def post = Action.async(parse.json) { req: Request[JsValue] =>
    req.body.validate[Claim].fold(
      errors => { Future { BadRequest(JsError.toJson(errors)) }},
      claim =>  { Future { Ok("Yes") }}
    )
  }

}
