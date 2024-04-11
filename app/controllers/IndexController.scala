package controllers

import play.api.libs.json.{Json, Writes}
import play.api.mvc.{Action, Controller}

case class Foo(f: String)

object Foo{
  implicit val writer: Writes[Foo] = Json.writes[Foo]
}

object IndexController extends Controller{

  def action1 = Action{
    Ok
  }

  def action2 = Action{
    NotFound
  }

  def action3 = Action{
    BadRequest
  }

  def action4 = Action{
    InternalServerError("Ooops")
  }

  def action5 = Action{
    Status(488)("Hello 488")
  }

  def action6 = Action{
    Ok(Json.toJson(Foo("foo")))
  }

  def action7(number: Int) = Action{
    Ok(s"The number is $number")
  }

  def action8(number1: Int, number2: Int) = Action{
    val sum = number1 + number2
    Ok(s"$number1 + $number2 = $sum")
  }

  def action9(name: String) = Action {
    if (name.nonEmpty) Ok(s"Hello, $name!")  else Ok("Hello, stranger!")
  }

  def action10 = Action(parse.json) { req =>
    Ok(req.body)
  }
}

