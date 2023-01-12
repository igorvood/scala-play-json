package ru.vood.example.play.seald

import play.api.libs.json.{Json, OWrites, Reads}

case class WrapperCaseClass(someSealed: SomeSealed)



object WrapperCaseClass {
  implicit val writes: OWrites[WrapperCaseClass] = Json.writes[WrapperCaseClass]

  implicit val reads: Reads[WrapperCaseClass] = Json.reads[WrapperCaseClass]
}