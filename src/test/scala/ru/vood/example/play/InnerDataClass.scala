package ru.vood.example.play

import play.api.libs.json.{Json, OWrites, Reads}

import java.util.Date

case class InnerDataClass(
                           birthDate: Date
                         )

object InnerDataClass {



  implicit val writes: OWrites[InnerDataClass] = Json.writes[InnerDataClass]

  implicit val reads: Reads[InnerDataClass] = Json.reads[InnerDataClass]
}