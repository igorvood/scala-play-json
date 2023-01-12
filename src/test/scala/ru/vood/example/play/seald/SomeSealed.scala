package ru.vood.example.play.seald

import play.api.libs.json.{Json, JsonConfiguration, JsonNaming, OWrites, Reads}



sealed trait SomeSealed {

}

case  class Case_1(num: Int) extends SomeSealed

object Case_1 {
  implicit val writes: OWrites[Case_1] = Json.writes[Case_1]

  implicit val reads: Reads[Case_1] = Json.reads[Case_1]
}

case  class Case_2(str: String) extends SomeSealed

object Case_2 {
  implicit val writes: OWrites[Case_2] = Json.writes[Case_2]

  implicit val reads: Reads[Case_2] = Json.reads[Case_2]
}

object SomeSealed {
  implicit val cfg = JsonConfiguration(
    // Each JSON objects is marked with the admTpe, ...
    discriminator = "type",
    // ... indicating the lower-cased name of sub-type
    typeNaming = JsonNaming { fullName =>
      fullName.split("\\.").last    }
  )


  implicit val writes: OWrites[SomeSealed] = Json.writes[SomeSealed]

  implicit val reads: Reads[SomeSealed] = Json.reads[SomeSealed]
}