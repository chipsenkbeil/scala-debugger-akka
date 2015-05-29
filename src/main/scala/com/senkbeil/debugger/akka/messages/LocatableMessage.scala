package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread}

abstract class LocatableMessage(
  val thread: Option[JDIThread],
  val location: Option[JDILocation]
) extends Serializable
