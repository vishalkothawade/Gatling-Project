package APIDemo.base

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object HttpProtocolConfig {
  val httpProtocol = http.baseUrl("https://reqres.in/api")
}
