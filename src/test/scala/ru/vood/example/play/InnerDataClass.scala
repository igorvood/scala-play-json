package ru.vood.example.play

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import play.api.libs.json._
//import play.api.data.format.Formats.dateFormat

case class InnerDataClass(
                           birthDate: DateTime
                         )

object InnerDataClass {

  //  val dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
  val dateFormat = "yyyy-MM-dd"


  implicit val jodaDateReads = Reads[DateTime](js =>
    js.validate[String].map[DateTime](dtString =>
      DateTime.parse(dtString, DateTimeFormat.forPattern(dateFormat))
    )
  )

  implicit val jodaDateWrites: Writes[DateTime] = new Writes[DateTime] {
    def writes(d: DateTime): JsValue = {

      JsString(d.toString(dateFormat))
    }
  }


  implicit val writes: OWrites[InnerDataClass] = Json.writes[InnerDataClass]

  implicit val reads: Reads[InnerDataClass] = Json.reads[InnerDataClass]

}