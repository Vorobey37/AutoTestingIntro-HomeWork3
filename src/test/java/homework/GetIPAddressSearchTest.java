package homework;


import org.hamcrest.Matchers;

import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class GetIPAddressSearchTest extends AccuweatherAbstractTest{

    @Test
    void testGetIPAddressSearch() {

        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/cities/ipaddress")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(1000L));

    }
}
