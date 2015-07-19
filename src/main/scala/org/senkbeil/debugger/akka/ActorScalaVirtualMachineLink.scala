package org.senkbeil.debugger.akka

import akka.actor.ActorRef
import org.senkbeil.debugger.akka.messages._
import org.senkbeil.debugger.akka.reflection.Reflector
import org.senkbeil.debugger.virtualmachines.ScalaVirtualMachine

import org.senkbeil.debugger.events.EventType
import com.sun.jdi.event._

import scala.reflect.runtime.{universe => ru}

private[akka] trait ActorScalaVirtualMachineLink {
  this: ScalaDebuggerAkkaExtensionImpl =>

  private val reflector = new Reflector(ru)

  /** Contains a mapping of event type names to the associated event types. */
  private val EventTypeMap = EventType.values
    .map(e => e.toString.toLowerCase -> e)
    .toMap

  def linkActorToScalaVirtualMachine(
    actorRef: ActorRef,
    scalaVirtualMachine: ScalaVirtualMachine,
    initialDataMap: Map[String, AnyRef]
  ): Unit = {
    initialDataMap
      .map(pair => pair._1.split("-").map(_.capitalize).mkString("") -> pair._2)
      .map(pair => stringToEventType(pair._1) -> pair._2)
      .filterNot(_._1.isEmpty)
      .map(pair => pair._1.get -> pair._2)
      .foreach(pair => {
        scalaVirtualMachine.eventManager.addResumingEventHandler(
          pair._1,
          processEvent(actorRef, _: Event, pair._2)
        )
      })
  }

  private def processEvent(actorRef: ActorRef, event: Event, data: AnyRef) = {
    // TODO: Implement recursive processing of map
    def buildMessage(event: Event, data: AnyRef): Map[String, AnyRef] = data match {
      case map: Map[_, _]     => ???
      case typeString: String => ???
      case _                  => ???
    }

    reflector.eventToMessageType(event).foreach(messageType => {
      val messageArgs = buildMessage(event, data)
      val message = reflector.createObject(messageType, messageArgs)
        .asInstanceOf[MessageLike]

      // Send the message to the actor
      actorRef ! message
    })
  }

  /**
   * Converts event type strings like "ClassPrepare" or "ClassPrepareType" to
   * their corresponding event types.
   *
   * @param eventTypeString The string representing the event type
   *
   * @return Some matching event type, otherwise None
   */
  private def stringToEventType(eventTypeString: String) = {
    val lowerCaseEventTypeString = eventTypeString.toLowerCase
    val eventType = EventTypeMap.get(lowerCaseEventTypeString)
      .orElse(EventTypeMap.get(lowerCaseEventTypeString + "type"))

    eventType
  }
}
