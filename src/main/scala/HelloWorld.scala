import com.amazonaws.services.lambda.runtime.Context
import com.itv.chuckwagon.lambda._
import io.circe.generic.auto._

case class Response(response:String)

class HelloWorld extends Handler[Unit, Response]{
  def handler(query:Unit, context:Context): Response = {
    Response("Hello World")
  }

}
