package ru.vood.example.play

import play.api.libs.json.{JsString, JsValue, Json, OWrites, Reads, Writes}

import java.util.Date
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
//import play.api.data.format.Formats.dateFormat
import java.text.SimpleDateFormat

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
//  implicit val CaseObjectFormat = Json.format[InnerDataClass]



//  private[this] def fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
//  implicit val format = Formats.dateFormat("yyyy-mm-dd")
//  implicit val config: Configuration = Configuration.default

//  implicit val dateEncoder: Encoder[Date] =
//    Encoder[String].contramap(fmt.format)
//  implicit val dateDecoder: Decoder[Date] =
//    Decoder[String].emapTry(str => Try(fmt.parse(str)))
//  implicit val dateReads = Reads.jodaDateReads("yyyy-MM-dd")
}