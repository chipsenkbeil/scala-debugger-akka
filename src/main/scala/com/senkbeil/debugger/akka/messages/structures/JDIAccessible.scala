package com.senkbeil.debugger.akka.messages.structures

abstract class JDIAccessible private[structures] (
  val isPackagePrivate: Option[Boolean],
  val isPrivate: Option[Boolean],
  val isProtected: Option[Boolean],
  val isPublic: Option[Boolean],
  val modifiers: Option[Int]
) extends Serializable
