package gatling;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class GatlingTest extends Simulation {
    HttpProtocolBuilder httpProtocolBuilder = HttpDsl.http.baseUrl(
            "http://sp17-env.eba-e9h7aw33.eu-central-1.elasticbeanstalk.com");

    public GatlingTest() {
        this.setUp(
                Scenario.reqGet.injectOpen(
                        CoreDsl.constantUsersPerSec(100)
                                .during(10)
                ),
                Scenario.reqPost.injectOpen(
                        CoreDsl.constantUsersPerSec(50)
                                .during(10)
                )
        ).protocols(httpProtocolBuilder);
    }

}