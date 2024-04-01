package homework;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.example.oneHourOfHourlyForecasts.WeatherInfo;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Forecast API")
public class Get1HourOfHourlyForecastsTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест Get1HourOfHourlyForecastsTest - значения поля IconPhrase погоды")
    @Description("Данный тест предназначен для проверки значения поля IconPhrase погоды на 1 час")
    @Link("https//developer.accuweather.com/")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Получение Weather для ключа 2515394")
    @Owner("Воробьев Алексей")
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
