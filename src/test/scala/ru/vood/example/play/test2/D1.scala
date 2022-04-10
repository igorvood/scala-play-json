package ru.vood.example.play.test2

import play.api.libs.functional.syntax._
import play.api.libs.json._
import ru.vood.example.play.test2.TypeAlias.Name


case class D1(name: Name,
              d2: D2
             ) {
  //  require(name.contains("!"), "name must contains '!'")
}

object D1 {


  implicit val writes: OWrites[D1] = Json.writes[D1]

  private val path: JsPath = __ \ "name"

  private val path1: JsPath = JsPath(List(KeyPathNode("name")))

  //  implicit val reads: Reads[D1] = Json.reads[D1]


  implicit val reads: Reads[D1] = (
    (__ \ "name").read[Name].filter(JsonValidationError("Name must contains '!'"))(_.contains("!")) and
      (__ \ "d2").read[D2]).tupled
    .map((D1.apply _).tupled)

}


/*
object ExampleCaseClass {
  implicit val exampleReads: Reads[ExampleCaseClass] = (
    (JsPath \ "username").read[String].filter(ValidationError("User does not exist."))(findByName(_).isDefined) and
      (JsPath \ "somethingElse").read[String]
    )(ExampleCaseClass.apply _)*/
