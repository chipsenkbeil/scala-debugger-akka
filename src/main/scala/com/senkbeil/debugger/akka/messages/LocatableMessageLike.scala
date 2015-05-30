package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocatableLike, JDILocation, JDIThread}

trait LocatableMessageLike extends JDILocatableLike with Serializable {
  val thread: Option[JDIThread]
  val location: Option[JDILocation]
}
