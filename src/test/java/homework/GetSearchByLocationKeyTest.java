package homework;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetSearchByLocationKeyTest extends AccuweatherAbstractTest{
    @Test
    void getGetSearchByLocationKey() {

        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/2515394")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(1000L));
    }
}