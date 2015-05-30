package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIValue, JDIMethod}

case class MethodExitMessage(
  thread: Option[JDIThread],
  location: Option[JDILocation],
  method: Option[JDIMethod],
  returnValue: Option[JDIValue]
) extends LocatableMessageLike

