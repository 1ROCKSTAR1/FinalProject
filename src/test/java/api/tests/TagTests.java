package api.tests;

import api.models.CreateTagReq;
import api.models.CreateTagResp;
import api.models.LoginReq;
import api.models.LoginResp;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class TagTests extends BaseApiTest {

    @Test
    @Epic("Api")
    @Feature("Tag")
    @DisplayName("Создание тега пользователя")
    public void createUserTagTest() {

        LoginReq loginReq = new LoginReq("sir.nevajn@yandex.ru", "driver_7890");

        LoginResp loginResp = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(loginReq)
                .when()
                .post("/v3/user/auth/local/login")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(LoginResp.class);

        String userId = loginResp.getData().getId();
        String apiToken = loginResp.getData().getApiToken();

        String tagName = faker.name().firstName();
        CreateTagReq createTagReq = new CreateTagReq(tagName);

        CreateTagResp createTagResp = given()
                .contentType(ContentType.JSON)
                .header("x-api-user", userId)
                .header("x-api-key", apiToken)
                .header("X-Client", userId + "-TestApp")
                .log().all()
                .body(createTagReq)
                .when()
                .post("/v3/tags")
                .then()
                .log().all()
                .statusCode(201)
                .extract().as(CreateTagResp.class);

        assertTrue(createTagResp.getSuccess());
        assertEquals(tagName, createTagResp.getData().getName());
        assertNotNull(createTagResp.getData().getId());
    }
}
