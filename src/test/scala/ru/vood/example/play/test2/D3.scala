package ru.vood.example.play.test2

import play.api.libs.json.{Json, OWrites, Reads}

case class D3(ints: List[Int])

object D3 {
  implicit val writes: OWrites[D3] = Json.writes[D3]

  implicit val reads: Reads[D3] = Json.reads[D3]

}