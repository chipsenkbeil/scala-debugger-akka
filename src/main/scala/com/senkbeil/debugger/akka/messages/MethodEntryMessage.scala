package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIMethod}

case class MethodEntryMessage(
  thread:   Option[JDIThread]   = None,
  location: Option[JDILocation] = None,
  method:   Option[JDIMethod]   = None
) extends LocatableMessageLike

