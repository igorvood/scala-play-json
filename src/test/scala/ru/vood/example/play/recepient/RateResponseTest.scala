package ru.vood.example.play.recepient

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import play.api.libs.json._

case class RateResponseTest(
                             id: String,
                             creationDate: DateTime,
                             originalMessageId: String,
                             systemCode: String,
                             details: String,
                             result: String
                           )

object RateResponseTest {
  val dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"

  implicit val jodaDateReads: Reads[DateTime] = Reads[DateTime](js =>
    js.validate[String].map[DateTime](dtString =>
      DateTime.parse(dtString, DateTimeFormat.forPattern(dateFormat))
    )
  )

  implicit val jodaDateWrites: Writes[DateTime] = (d: DateTime) => JsString(d.toString(dateFormat))


  implicit val writes: OWrites[RateResponseTest] = Json.writes[RateResponseTest]

  implicit val reads: Reads[RateResponseTest] = Json.reads[RateResponseTest]

}