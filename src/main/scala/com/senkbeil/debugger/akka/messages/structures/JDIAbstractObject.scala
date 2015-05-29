package com.senkbeil.debugger.akka.messages.structures

abstract class JDIAbstractObject private[structures] (
  val entryCount: Option[Int],
  val isCollected: Option[Boolean],
  val owningThread: Option[JDIThread],
  val referenceType: Option[JDIReferenceType],
  // NOTE: This takes a single argument for max references to return,
  //       which can be 0 (to return all references), but 1) how would you
  //       communicate that 0 should be provided and 2) should all references
  //       be returned (expensive)?
  /*val referringObjects: Option[Seq[JDIObject]],*/
  val uniqueId: Option[Long],
  val waitingThreads: Option[Seq[JDIThread]]
) extends Serializable
