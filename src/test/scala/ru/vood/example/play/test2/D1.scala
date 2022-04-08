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


  val combined: Reads[(Name, D2)] = ((__ \ "name").read[Name] and (__ \ "d2").read[D2]).tupled

  implicit val reads: Reads[D1] = combined.map((D1.apply _).tupled)

}


