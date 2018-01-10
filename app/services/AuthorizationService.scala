package services

import models.{Claim, RaAuthorization, RaAuthorizationRepository}
import javax.inject.{Inject, Singleton}

import scala.concurrent.Future

class AuthorizationService @Inject()(rar: RaAuthorizationRepository) {
  def initiate(email: String): Future[RaAuthorization] = {
    rar.create(RaAuthorization(None, "Initialized", email))
  }

  def find(id: String): Future[Option[RaAuthorization]] = {
    rar.findById(id)
  }

  def findAll: Future[Seq[RaAuthorization]] = {
    rar.findAll
  }

  def addClaim(claim: Claim) = {

  }
}
