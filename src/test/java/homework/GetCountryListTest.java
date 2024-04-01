package homework;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class GetCountryListTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест getCountryListReturn200 - проверка соответствия статуса и времени ответа")
    @Description("Данный тест предназначен для проверки статуса и времени ответа на валидный запрос")
    @Link("https//developer.accuweather.com/")
    @Severity(SeverityLevel.MINOR)
    @Story("Вызов метода получения списка стран")
    @Owner("Воробьев Алексей")
    void getCountryListReturn200() {

        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/countries/")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L));
    }
}
