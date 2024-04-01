package homework;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.example.GetCityNeighborsByLocationKey.CitiesInfo;
import org.example.oneHourOfHourlyForecasts.WeatherInfo;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class GetCityNeighborsByLocationKeyTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест GetCityNeighborsByLocationKey - получение имени города-соседа")
    @Description("Данный тест предназначен для проверки возвращаемого имени города-соседа")
    @Link("https//developer.accuweather.com/")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Получение Location для ключа 2515394")
    @Owner("Воробьев Алексей")
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
