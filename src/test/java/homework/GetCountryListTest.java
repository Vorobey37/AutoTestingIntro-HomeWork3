package homework;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetCountryListTest extends AccuweatherAbstractTest{

    @Test
    void getCountryListReturn200() {

        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/countries/")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(1000L));
    }
}
