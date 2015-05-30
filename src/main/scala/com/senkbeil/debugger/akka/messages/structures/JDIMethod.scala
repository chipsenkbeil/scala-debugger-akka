package com.senkbeil.debugger.akka.messages.structures

case class JDIMethod(
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
  allLineLocations: Option[Seq[JDILocation]],
  arguments: Option[Seq[JDILocalVariable]],
  location: Option[JDILocation],
  returnType: Option[JDIType],
  variables: Option[Seq[JDILocalVariable]]
) extends JDITypeComponentLike with JDILocatableLike
