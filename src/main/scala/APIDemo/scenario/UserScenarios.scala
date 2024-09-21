package APIDemo.scenario

import io.gatling.core.Predef._
import APIDemo.chainbuilder.APIDemoChainbuilders

object UserScenarios {
  /* val getUserScenario = scenario("Get API Demo")
    .exec(GetUser.getUser)

  val createUserScenario = scenario("POST API Demo")
    .exec(CreateUser.createUser)

  val updateUserScenario = scenario("Update User")
    .exec(UpdateUser.updateUser) */

  val UserScenario = scenario("User Flow API Demo")
    .exec(APIDemoChainbuilders.getUser)
    .exec(APIDemoChainbuilders.createUser)
    .exec(APIDemoChainbuilders.updateUser)
}
