package gatling;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.http.HttpDsl;

import static io.gatling.javaapi.core.CoreDsl.StringBody;

public class Steps {
    public static ChainBuilder getReg = CoreDsl.exec(
            HttpDsl
                    .http("get request")
                    .get("/task")
                    .check(HttpDsl.status().is(200))

    );
    public static ChainBuilder postReg = CoreDsl.exec(
            HttpDsl
                    .http("post request")
                    .post("/task")
                    .basicAuth("Admin","admin")
                    .header("Content-type","application/json")
                    .body(StringBody("{\"taskDescription\": \"string\",\"targetDate\":" +
                            " \"2023-09-05\",\"extendedState\": \"string\"}"))
                    .check(HttpDsl.status().is(200))
    );

}
