package ru.vood.example.play.test2

import play.api.libs.json.{Json, OWrites, Reads}

case class D2(serName: String,
              d3: D3)

object D2{
  implicit val writes: OWrites[D2] = Json.writes[D2]

  implicit val reads: Reads[D2] = Json.reads[D2]

}