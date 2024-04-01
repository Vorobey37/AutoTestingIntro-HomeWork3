package homework;


import io.qameta.allure.*;
import jdk.jfr.Description;
import org.hamcrest.Matchers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class GetIPAddressSearchTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест GetIPAddressSearch - проверка соответствия статуса и времени ответа")
    @Description("Данный тест предназначен для проверки статуса и времени ответа на валидный запрос")
    @Link("https//developer.accuweather.com/")
    @Severity(SeverityLevel.NORMAL)
    @Story("Вызов метода для поиска по ipaddress")
    @Owner("Воробьев Алексей")
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
