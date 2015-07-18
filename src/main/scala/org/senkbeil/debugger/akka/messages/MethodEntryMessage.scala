package org.senkbeil.debugger.akka.messages

import org.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIMethod}

case class MethodEntryMessage(
  thread:   Option[JDIThread]   = None,
  location: Option[JDILocation] = None,
  method:   Option[JDIMethod]   = None
) extends LocatableMessageLike with MessageLike

