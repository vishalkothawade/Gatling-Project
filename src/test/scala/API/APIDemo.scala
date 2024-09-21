package API

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class APIDemo extends Simulation {

  //Protocol
  val httpProtocol = http.baseUrl("https://reqres.in/api")

  // Scenario GET : for Get User
  val getUser = scenario("Get API Demo")
    .exec(
      http("Get User")
        .get("/users/2")
        .check(status.is(200))
        .check(jsonPath("$.data.first_name").is("Janet"))
    ).pause(2)

  // Scenario POST: for Create User
  val createUser = scenario("POST API Demo")
    .exec(
      http("Create User")
        .post("/users")
        .asJson
        .body(RawFileBody("data/user.json")).asJson

//        .body(StringBody(
//          """
//            |{
//            |    "name": "Henry",
//
//
//            |    "job": "leader"
//            |}
//            |""".stripMargin)).asJson
        .check(
          status.is(201),
          jsonPath("$.name").is("Henry")
        )
    )

  // Create Scenario PUT: for
  val updateUser = scenario("Update User")
    .exec(
      http("PUT")
        .put("/users/2")
        .asJson
        .body(RawFileBody("data/user.json"))
        .check(
        status.is(200),
          jsonPath("$.name").is("Henry")
        )

    )

  // Setup
  setUp(
    getUser.inject(atOnceUsers(10)),
    createUser.inject(atOnceUsers(7)),
    updateUser.inject(atOnceUsers(5))
  ).protocols(httpProtocol)

}
