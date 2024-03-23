package homework;

import org.example.GetCityNeighborsByLocationKey.CitiesInfo;
import org.example.oneHourOfHourlyForecasts.WeatherInfo;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetCityNeighborsByLocationKeyTest extends AccuweatherAbstractTest{

    @Test
    void testGetCityNeighborsByLocationKey() {

        List<CitiesInfo> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/cities/neighbors/2515394")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(1000L))
                .extract()
                .body().jsonPath().getList(".", CitiesInfo.class);

        Assertions.assertEquals(10,response.size());
        Assertions.assertEquals("Avtovo", response.get(0).getLocalizedName());
    }
}
