package org.senkbeil.debugger.akka.messages.structures

trait JDIAccessibleLike extends Serializable {
  val isPackagePrivate: Option[Boolean]
  val isPrivate:        Option[Boolean]
  val isProtected:      Option[Boolean]
  val isPublic:         Option[Boolean]
  val modifiers:        Option[Int]
}
