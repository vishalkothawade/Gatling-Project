package APIDemo.chainbuilder

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object APIDemoChainbuilders {
  // ChainBuilder for the GET User request
  val getUser = exec(
    http("Get User")
      .get("/users/2")
      .check(status.is(200))
      .check(jsonPath("$.data.first_name").is("Janet"))
  ).pause(2)

  // ChainBuilder for the POST Create User request
  val createUser = exec(
    http("Create User")
      .post("/users")
      .asJson
      .body(RawFileBody("data/user.json")).asJson
      .check(
        status.is(201),
        jsonPath("$.name").is("Henry")
      )
  ).pause(2)

  // ChainBuilder for the PUT Update User request
  val updateUser = exec(
    http("Update User")
      .put("/users/2")
      .asJson
      .body(RawFileBody("data/user.json"))
      .check(
        status.is(200),
        jsonPath("$.name").is("Henry")
      )
  ).pause(2)
}
