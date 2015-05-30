package com.senkbeil.debugger.akka.messages.structures

trait JDIReferenceTypeLike extends Serializable {
  val allFields: Option[Seq[JDIField]]
  val allLineLocations: Option[Seq[JDILocation]]
  val allMethods: Option[Seq[JDIMethod]]
  val availableStrata: Option[Seq[String]]
  val classLoader: Option[JDIClassLoader]
  val classObject: Option[JDIClassObject]
  val constantPool: Option[Array[Byte]]
  val constantPoolCount: Option[Int]
  val defaultStratum: Option[String]
  val failedToInitialize: Option[Boolean]
  val fields: Option[Seq[JDIField]]
  val genericSignature: Option[String]
  // NOTE: This takes a single argument for max references to return,
  //       which can be 0 (to return all references), but 1) how would you
  //       communicate that 0 should be provided and 2) should all references
  //       be returned (expensive)?
  /*val instances: Option[Seq[JDIObject]],*/
  val isAbstract: Option[Boolean]
  val isFinal: Option[Boolean]
  val isInitialized: Option[Boolean]
  val isPrepared: Option[Boolean]
  val isStatic: Option[Boolean]
  val isVerified: Option[Boolean]
  val majorVersion: Option[Int]
  val methods: Option[Seq[JDIMethod]]
  val minorVersion: Option[Int]
  val name: Option[String]
  val nestedTypes: Option[Seq[JDIReferenceType]]
  val sourceDebugExtension: Option[String]
  val sourceName: Option[String]
  val visibleFields: Option[Seq[JDIField]]
  val visibleMethods: Option[Seq[JDIMethod]]
}
