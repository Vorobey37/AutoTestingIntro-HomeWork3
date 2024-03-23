package homework;

import org.example.oneHourOfHourlyForecasts.WeatherInfo;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Get1HourOfHourlyForecastsTest extends AccuweatherAbstractTest{

    @Test
    void testGetOneHourOfHourlyForecasts() {

        List<WeatherInfo> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/forecasts/v1/hourly/1hour/2515394")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(1000L))
                .extract()
                .body().jsonPath().getList(".", WeatherInfo.class);

        Assertions.assertEquals(1,response.size());
        Assertions.assertEquals("Cloudy", response.get(0).getIconPhrase());
    }
}
