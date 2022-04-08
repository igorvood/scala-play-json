package ru.vood.example.play.test2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import play.api.libs.json.{JsError, JsSuccess, Json}


import java.util.Date

class Test extends AnyFlatSpec with should.Matchers {


  "json DslJsonRandomMeta determenistic test" should "be called DataClas3232s" in {
    val list = (1 to 3).toList

    val data = D1("data1", D2("batit", D3(list)))

    val jsObject = Json.toJsObject(data)


    println(Json.prettyPrint(jsObject))


  }



  "json DslJsonRandomMeta determenistic test" should "be called DataClass222" in {

    val margin =
      """{
        |  "name" : "data1",
        |  "d2" : {
        |    "serName" : "batit",
        |    "d3" : {
        |      "ints" : [ "1", 2, 3 ]
        |    }
        |  }
        |}""".stripMargin


    val value1 = Json.parse(margin)

    val value2 = value1.validate[D1]

    value2 match {
      case JsError(eee) => println(eee.mkString("\n"))
    }

//    val value3 = value1.as[D1]
  }

  /*"json DslJsonRandomMeta determenistic test" should "be called DataClass errr" in {

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
*/

}
