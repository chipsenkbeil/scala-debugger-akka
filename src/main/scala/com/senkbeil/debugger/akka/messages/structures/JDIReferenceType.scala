package com.senkbeil.debugger.akka.messages.structures

case class JDIReferenceType(
  override val allFields: Option[Seq[JDIField]],
  override val allLineLocations: Option[Seq[JDILocation]],
  override val allMethods: Option[Seq[JDIMethod]],
  override val availableStrata: Option[Seq[String]],
  override val classLoader: Option[JDIClassLoader],
  override val classObject: Option[JDIClassObject],
  override val constantPool: Option[Array[Byte]],
  override val constantPoolCount: Option[Int],
  override val defaultStratum: Option[String],
  override val failedToInitialize: Option[Boolean],
  override val fields: Option[Seq[JDIField]],
  override val genericSignature: Option[String],
  override val isAbstract: Option[Boolean],
  override val isFinal: Option[Boolean],
  override val isInitialized: Option[Boolean],
  override val isPrepared: Option[Boolean],
  override val isStatic: Option[Boolean],
  override val isVerified: Option[Boolean],
  override val majorVersion: Option[Int],
  override val methods: Option[Seq[JDIMethod]],
  override val minorVersion: Option[Int],
  override val name: Option[String],
  override val nestedTypes: Option[Seq[JDIReferenceType]],
  override val sourceDebugExtension: Option[String],
  override val sourceName: Option[String],
  override val visibleFields: Option[Seq[JDIField]],
  override val visibleMethods: Option[Seq[JDIMethod]]
) extends JDIAbstractReferenceType(
  allFields = allFields,
  allLineLocations = allLineLocations,
  allMethods = allMethods,
  availableStrata = availableStrata,
  classLoader = classLoader,
  classObject = classObject,
  constantPool = constantPool,
  constantPoolCount = constantPoolCount,
  defaultStratum = defaultStratum,
  failedToInitialize = failedToInitialize,
  fields = fields,
  genericSignature = genericSignature,
  isAbstract = isAbstract,
  isFinal = isFinal,
  isInitialized = isInitialized,
  isPrepared = isPrepared,
  isStatic = isStatic,
  isVerified = isVerified,
  majorVersion = majorVersion,
  methods = methods,
  minorVersion = minorVersion,
  name = name,
  nestedTypes = nestedTypes,
  sourceDebugExtension = sourceDebugExtension,
  sourceName = sourceName,
  visibleFields = visibleFields,
  visibleMethods = visibleMethods
)
