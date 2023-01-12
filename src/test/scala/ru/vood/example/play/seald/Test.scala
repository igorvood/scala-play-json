package ru.vood.example.play.seald

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import play.api.libs.json.{JsObject, Json}

class Test extends AnyFlatSpec with should.Matchers {


  "json DslJsonRandomMeta determenistic test" should "be called DataClass" in {
    val innerData = WrapperCaseClass(new Case_1(1))


    val value2: JsObject = Json.toJsObject(innerData)
    val str: String = Json.stringify(value2)
    println(str)


    val jsRes = Json.parse("""{"someSealed":{"type":"Case_1","num":1}}""")

    val value1 = Json.fromJson[WrapperCaseClass](jsRes)
    println(value1)
    //    val jsRes = Json.parse(
    //      """{"bool":true,"str":"strval","int":1,"innerObj":{"birthDate":"2022-06-01"},"innerList":[{"birthDate":"2022-06-01"}],"innerMap":{"1":{"birthDate":"2022-06-01"},"2":{"birthDate":"2022-06-01"}}}""")
    //
    //    val value1 = Json.fromJson[DataClass](jsRes)
    //
    //    value1 match {
    //      case JsSuccess(value, path) => println(value)
    //        println(path)
    //    }

    //      println(value1)

  }


}
