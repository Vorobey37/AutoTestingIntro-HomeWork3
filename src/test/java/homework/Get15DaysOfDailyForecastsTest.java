package homework;

import io.qameta.allure.*;

import jdk.jfr.Description;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Forecast API")
public class Get15DaysOfDailyForecastsTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест проверки ответа 401(негативный) и времени при вызове метода Get15DaysOfDailyForecasts")
    @Description("Данный тест предназначен для проверки возвращаемого ответа 401 на получение значений погоды на 15 дней")
    @Link("https//developer.accuweather.com/")
    @Severity(SeverityLevel.MINOR)
    @Story("Вызов метода получения погоды за 15 дней")
    @Owner("Воробьев Алексей")
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
