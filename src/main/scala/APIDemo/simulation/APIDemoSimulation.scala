package APIDemo.simulation

import io.gatling.core.Predef._
import APIDemo.base.HttpProtocolConfig
import APIDemo.scenario.UserScenarios

class APIDemoSimulation extends Simulation {
  /* setUp(
    UserScenarios.getUserScenario.inject(atOnceUsers(10)),
    UserScenarios.createUserScenario.inject(atOnceUsers(7)),
    UserScenarios.updateUserScenario.inject(atOnceUsers(5))
  ).protocols(HttpProtocolConfig.httpProtocol) */

  setUp(
    UserScenarios.UserScenario.inject(atOnceUsers(10))
    ).protocols(HttpProtocolConfig.httpProtocol)
}
