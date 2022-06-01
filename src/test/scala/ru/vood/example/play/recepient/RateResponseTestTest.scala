package ru.vood.example.play.recepient

import org.joda.time.DateTime
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import play.api.libs.json.Json
import ru.vood.example.play.InnerDataClass

class RateResponseTestTest extends AnyFlatSpec with should.Matchers {


  "json DslJsonRandomMeta determenistic test" should "be called DataClass" in {
    val rateResponseTest = RateResponseTest(
      "id",
      new DateTime(),
      "originalId",
      "systemCode",
      null,
      "SUCCESS"
    )
    val jsObject = Json.toJsObject(rateResponseTest)
    println(Json.stringify(jsObject))

  }

}
