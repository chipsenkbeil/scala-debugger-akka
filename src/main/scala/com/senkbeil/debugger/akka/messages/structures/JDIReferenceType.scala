package com.senkbeil.debugger.akka.messages.structures

// NOTE: This pain point (22 argument limit) is fixed in Scala 2.11
//       https://github.com/scala/scala/pull/2305
case class JDIReferenceType(
  allFields: Option[Seq[JDIField]],
  allLineLocations: Option[Seq[JDILocation]],
  allMethods: Option[Seq[JDIMethod]],
  availableStrata: Option[Seq[String]],
  classLoader: Option[JDIClassLoader],
  classObject: Option[JDIClassObject],
  constantPool: Option[Array[Byte]],
  constantPoolCount: Option[Int],
  defaultStratum: Option[String],
  failedToInitialize: Option[Boolean],
  fields: Option[Seq[JDIField]],
  genericSignature: Option[String],
  isAbstract: Option[Boolean],
  isFinal: Option[Boolean],
  isInitialized: Option[Boolean],
  isPrepared: Option[Boolean],
  isStatic: Option[Boolean],
  isVerified: Option[Boolean],
  majorVersion: Option[Int],
  methods: Option[Seq[JDIMethod]],
  minorVersion: Option[Int],
  name: Option[String]
)(
  override val nestedTypes: Option[Seq[JDIReferenceType]],
  override val sourceDebugExtension: Option[String],
  override val sourceName: Option[String],
  override val visibleFields: Option[Seq[JDIField]],
  override val visibleMethods: Option[Seq[JDIMethod]]
) extends JDIReferenceTypeLike

