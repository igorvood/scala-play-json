package ru.vood.example.play

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import play.api.libs.json.{JsError, JsResult, JsSuccess, Json}

import java.util.Date

class Test extends AnyFlatSpec with should.Matchers {


  "json DslJsonRandomMeta determenistic test" should "be called DataClass" in {
    val innerData = InnerDataClass(new Date())

    val data = DataClass(true, Some("strval"), 1, innerData, List(innerData), Map("1" -> innerData, "2" -> innerData))
//    println(Json.toJson(innerData))

//    println(Json.toJson(data))

    Json.toJsObject(data)

    val jsRes = Json.parse(
    """{"bool":true,"str":"strval","int":1,"innerObj":{"birthDate":1649424304158},"innerList":[{"birthDate":1649424304158}],"innerMap":{"1":{"birthDate":1649424304158},"2":{"birthDate":1649424304158}}}""")

    val value1 = Json.fromJson[DataClass](jsRes)

    value1 match {
      case JsSuccess(value, path) => println(value)
        println(path)
    }

//    println(value1)

  }


  "json DslJsonRandomMeta determenistic test" should "be called DataClass errr" in {

    val jsRes = Json.parse(
      """{"bool":"true","str":"strval","int2":1,"innerObj":{"birthDate":1649424304158},"innerList":[{"birthDate":1649424304158}],"innerMap":{"1":{"birthDate":1649424304158},"2":{"birthDate":1649424304158}}}""")

    val value1 = Json.fromJson[DataClass](jsRes)

//    println(value1)

    value1 match {
      case JsError(eee) => println(eee.mkString("\n"))
    }

  }

  "json DslJsonRandomMeta determenistic test" should "be called InnerDataClass" in {
    val innerData = InnerDataClass(new Date())
    println(Json.toJson(innerData))
    val value1 = Json.parse("""{"birthDate":1649425458139}""")
    println(Json.fromJson[InnerDataClass](value1))
  }


}
