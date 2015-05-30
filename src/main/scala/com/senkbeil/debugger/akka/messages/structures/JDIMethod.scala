package com.senkbeil.debugger.akka.messages.structures

case class JDIMethod(
  isPackagePrivate: Option[Boolean]               = None,
  isPrivate:        Option[Boolean]               = None,
  isProtected:      Option[Boolean]               = None,
  isPublic:         Option[Boolean]               = None,
  modifiers:        Option[Int]                   = None,
  declaringType:    Option[JDIReferenceType]      = None,
  genericSignature: Option[String]                = None,
  isFinal:          Option[Boolean]               = None,
  isStatic:         Option[Boolean]               = None,
  isSynthetic:      Option[Boolean]               = None,
  name:             Option[String]                = None,
  signature:        Option[String]                = None,
  allLineLocations: Option[Seq[JDILocation]]      = None,
  arguments:        Option[Seq[JDILocalVariable]] = None,
  location:         Option[JDILocation]           = None,
  returnType:       Option[JDIType]               = None,
  variables:        Option[Seq[JDILocalVariable]] = None
) extends JDITypeComponentLike with JDILocatableLike
