package org.senkbeil.debugger.akka.messages.structures

case class JDIField(
  isPackagePrivate: Option[Boolean]           = None,
  isPrivate:        Option[Boolean]           = None,
  isProtected:      Option[Boolean]           = None,
  isPublic:         Option[Boolean]           = None,
  modifiers:        Option[Int]               = None,
  declaringType:    Option[JDIReferenceType]  = None,
  genericSignature: Option[String]            = None,
  isFinal:          Option[Boolean]           = None,
  isStatic:         Option[Boolean]           = None,
  isSynthetic:      Option[Boolean]           = None,
  name:             Option[String]            = None,
  signature:        Option[String]            = None,
  isTransient:      Option[Boolean]           = None,
  isVolatile:       Option[Boolean]           = None,
  `type`:           Option[JDIType]           = None
) extends JDITypeComponentLike
