package org.senkbeil.debugger.akka.messages.structures

trait JDILocatableLike extends Serializable {
  val location: Option[JDILocation]
}
