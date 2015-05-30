package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures._

trait WatchpointMessageLike extends LocatableMessageLike with Serializable {
  val field:        Option[JDIField]
  val `object`:     Option[JDIObject]
  val valueCurrent: Option[JDIValue]
}
