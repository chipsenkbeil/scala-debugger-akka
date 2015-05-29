package com.senkbeil.debugger.akka.messages.structures

case class JDIField(
  override val isPackagePrivate: Option[Boolean],
  override val isPrivate: Option[Boolean],
  override val isProtected: Option[Boolean],
  override val isPublic: Option[Boolean],
  override val modifiers: Option[Int],
  override val declaringType: Option[JDIReferenceType],
  override val genericSignature: Option[String],
  override val isFinal: Option[Boolean],
  override val isStatic: Option[Boolean],
  override val isSynthetic: Option[Boolean],
  override val name: Option[String],
  override val signature: Option[String],
  isTransient: Option[Boolean],
  isVolatile: Option[Boolean],
  `type`: Option[JDIType]
) extends JDITypeComponent(
  isPackagePrivate  = isPackagePrivate,
  isPrivate         = isPrivate,
  isProtected       = isProtected,
  isPublic          = isPublic,
  modifiers         = modifiers,
  declaringType     = declaringType,
  genericSignature  = genericSignature,
  isFinal           = isFinal,
  isStatic          = isStatic,
  isSynthetic       = isSynthetic,
  name              = name,
  signature         = signature
)
