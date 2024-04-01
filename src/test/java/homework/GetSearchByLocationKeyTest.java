package homework;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class GetSearchByLocationKeyTest extends AccuweatherAbstractTest{
    @Test
    @DisplayName("Тест GetSearchByLocationKey - проверка статуса и времени ответа")
    @Description("Данный тест предназначен для проверки статуса и времени ответа на валидный запрос")
    @Link("https//developer.accuweather.com/")
    @Severity(SeverityLevel.NORMAL)
    @Story("Вызов метода поиска по ключу 2515394")
    @Owner("Воробьев Алексей")
    void testGetSearchByLocationKey() {

        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/2515394")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L));
    }
}
