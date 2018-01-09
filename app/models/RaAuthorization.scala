package models
import play.api.libs.json._

case class RaAuthorization(id: Option[String], status: String, email: String)

object RaAuthorization {
  implicit val raAuthorizationFormat = Json.format[RaAuthorization]
}

