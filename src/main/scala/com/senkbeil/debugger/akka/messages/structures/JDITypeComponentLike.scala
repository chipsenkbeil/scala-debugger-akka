package com.senkbeil.debugger.akka.messages.structures

trait JDITypeComponentLike extends JDIAccessibleLike with Serializable {
  val declaringType:    Option[JDIReferenceType]
  val genericSignature: Option[String]
  val isFinal:          Option[Boolean]
  val isStatic:         Option[Boolean]
  val isSynthetic:      Option[Boolean]
  val name:             Option[String]
  val signature:        Option[String]
}

