package com.senkbeil.debugger.akka.messages.structures

abstract class JDITypeComponent private[structures] (
  override val isPackagePrivate: Option[Boolean],
  override val isPrivate: Option[Boolean],
  override val isProtected: Option[Boolean],
  override val isPublic: Option[Boolean],
  override val modifiers: Option[Int],
  val declaringType: Option[JDIReferenceType],
  val genericSignature: Option[String],
  val isFinal: Option[Boolean],
  val isStatic: Option[Boolean],
  val isSynthetic: Option[Boolean],
  val name: Option[String],
  val signature: Option[String]
) extends JDIAccessible(
  isPackagePrivate  = isPackagePrivate,
  isPrivate         = isPrivate,
  isProtected       = isProtected,
  isPublic          = isPublic,
  modifiers         = modifiers
) with Serializable

