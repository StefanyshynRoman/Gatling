package gatling;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.ScenarioBuilder;

public class Scenario {
    public static ScenarioBuilder reqGet = CoreDsl.scenario("Get task scenario")
            .exec(Steps.getReg);
    public static ScenarioBuilder reqPost = CoreDsl.scenario("Get post scenario")
            .exec(Steps.postReg);
}
