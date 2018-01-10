package models

import javax.inject.{Inject, Singleton}

import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import java.util.UUID.randomUUID

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Failure

@Singleton
class RaAuthorizationRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit  ec: ExecutionContext){
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  private class RaAuthorizationTable(tag: Tag) extends Table[RaAuthorization](tag, "ra_authorizations") {

    def id: Rep[String] = column[String]("id", O.PrimaryKey)
    def status: Rep[String] = column[String]("status")
    def email: Rep[String] = column[String]("email")

    def * = (id.?, status, email) <> ((RaAuthorization.apply _).tupled, RaAuthorization.unapply)
  }

  private val authorizations = TableQuery[RaAuthorizationTable]

  def create(authorization: RaAuthorization): Future[RaAuthorization] = {
    val auth = authorization.copy(id=Some(randomUUID.toString))
    db.run { authorizations += auth }.map {
      case 1 => auth
      case _ => throw new Exception("Failed to create RA")
    }
  }

  def findById(id: String) : Future[Option[RaAuthorization]] = {
    db.run(authorizations.filter(_.id === id).result.headOption)
  }

  def findAll(): Future[Seq[RaAuthorization]] = db.run(authorizations.result)

  def addClaim(claim: Claim) = {
//    auth
  }
}
