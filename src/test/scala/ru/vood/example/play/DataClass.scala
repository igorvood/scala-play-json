package ru.vood.example.play

import play.api.libs.json.{Json, OWrites, Reads}

case class DataClass(
                      bool: Boolean,
                      str: Option[String],
                      int: Int,
                      innerObj: InnerDataClass,
                      innerList: List[InnerDataClass],
                      innerMap: Map[String, InnerDataClass]
                    )

object DataClass {
  implicit val writes: OWrites[DataClass] = Json.writes[DataClass]

  implicit val reads: Reads[DataClass] = Json.reads[DataClass]
}