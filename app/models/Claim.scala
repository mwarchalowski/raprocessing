package models
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import java.time.LocalDate
import java.time.format.DateTimeFormatter

import play.api.libs.json._

case class Claim(
                  id: Option[String],
                  raAuthorizationId: String,
                  firstName: String,
                  lastName: String,
                  phone: String,
                  email: String,
                  order: String,
                  sku: String,
                  trackingNumber: String,
                  dateReceived: LocalDate,
                  description: String
                ) {

}

object Claim {
  implicit val claim: Writes[Claim] = Json.writes[Claim]

  implicit val claimReads:Reads[Claim] = (
    (JsPath \ "id").readNullable[String] and
      (JsPath \ "raAuthorizationId").read[String].filter(JsonValidationError("Ra Does not exist."))(_ == "Test") and
      (JsPath \ "firstName").read[String] and
      (JsPath \ "lastName").read[String] and
      (JsPath \ "phone").read[String] and
      (JsPath \ "email").read[String](email) and
      (JsPath \ "order").read[String] and
      (JsPath \ "sku").read[String] and
      (JsPath \ "trackingNumber").read[String] and
      (JsPath \ "dateReceived").read[LocalDate](localDateReads(DateTimeFormatter.ISO_DATE)) and
      (JsPath \ "description").read[String]
    )(Claim.apply _)
}
