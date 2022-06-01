package ru.vood.example.play

import org.joda.time.DateTime
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import play.api.libs.json.{JsError, JsObject, JsResult, JsSuccess, Json}

import java.util.Date

class Test extends AnyFlatSpec with should.Matchers {


  "json DslJsonRandomMeta determenistic test" should "be called DataClass" in {
    val innerData = InnerDataClass(new DateTime())

    val data = DataClass(true, Some("strval"), 1, innerData, List(innerData), Map("1" -> innerData, "2" -> innerData))
//    println(Json.toJson(innerData))

//    println(Json.toJson(data))

    val value2: JsObject = Json.toJsObject(data)
    val str: String = Json.stringify(value2)
    println(str)

    val jsRes = Json.parse(
    """{"bool":true,"str":"strval","int":1,"innerObj":{"birthDate":"2022-06-01"},"innerList":[{"birthDate":"2022-06-01"}],"innerMap":{"1":{"birthDate":"2022-06-01"},"2":{"birthDate":"2022-06-01"}}}""")

    val value1 = Json.fromJson[DataClass](jsRes)

    value1 match {
      case JsSuccess(value, path) => println(value)
        println(path)
    }

//      println(value1)

  }


  "json DslJsonRandomMeta determenistic test" should "be called DataClass errr" in {

    val jsRes = Json.parse(
      """{"bool":"true","str":"strval","int2":1,"innerObj":{"birthDate":1649424304158},"innerList":[{"birthDate":1649424304158}],"innerMap":{"1":{"birthDate":1649424304158},"2":{"birthDate":1649424304158}}}""")

    val value1 = Json.fromJson[DataClass](jsRes)

    value1.get

//    println(value1)

    value1 match {
      case JsError(eee) => println(eee.mkString("\n"))
    }

  }

  "json DslJsonRandomMeta determenistic test" should "be called InnerDataClass" in {
    val innerData = InnerDataClass(new DateTime())
    println(Json.toJson(innerData))
    val value1 = Json.parse("""{"birthDate":1649425458139}""")
    println(Json.fromJson[InnerDataClass](value1))
  }


}
