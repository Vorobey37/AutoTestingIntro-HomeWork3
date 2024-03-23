package homework;

import io.restassured.http.Method;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Get15DaysOfDailyForecastsTest extends AccuweatherAbstractTest{

    @Test
    void getFifteenDaysReturn401() {

        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", 2515394)
                .when()
                .get(getBaseUrl()+"/forecasts/{version}/daily/15day/{location}")
                .then()
                .statusCode(401)
                .time(Matchers.lessThan(1000L));
    }
}
