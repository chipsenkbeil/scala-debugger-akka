package com.senkbeil.debugger.akka.messages.structures

case class JDIField(
  isPackagePrivate: Option[Boolean],
  isPrivate: Option[Boolean],
  isProtected: Option[Boolean],
  isPublic: Option[Boolean],
  modifiers: Option[Int],
  declaringType: Option[JDIReferenceType],
  genericSignature: Option[String],
  isFinal: Option[Boolean],
  isStatic: Option[Boolean],
  isSynthetic: Option[Boolean],
  name: Option[String],
  signature: Option[String],
  isTransient: Option[Boolean],
  isVolatile: Option[Boolean],
  `type`: Option[JDIType]
) extends JDITypeComponentLike
