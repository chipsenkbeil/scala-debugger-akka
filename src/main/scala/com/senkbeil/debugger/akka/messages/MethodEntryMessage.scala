package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIMethod}

case class MethodEntryMessage(
  thread: Option[JDIThread],
  location: Option[JDILocation],
  method: Option[JDIMethod]
) extends LocatableMessageLike

