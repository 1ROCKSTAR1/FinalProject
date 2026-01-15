package api.tests;

import api.models.*;
import api.specs.TagSpec;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.specs.LoginUserSpec.loginReqSpec;
import static api.specs.TagSpec.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class TagTests extends BaseApiTest {

    @Test
    @Epic("Api")
    @Feature("Tag")
    @DisplayName("Создание тега пользователя")
    public void createUserTagTest() {

        LoginReq loginReq = new LoginReq("sir.nevajn@yandex.ru", "driver_7890");

        LoginResp loginResp = given(loginReqSpec)
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

        RequestSpecification authSpec = TagSpec.createTagSpec(userId, apiToken);

        CreateTagResp createTagResp = given(authSpec)
                .body(createTagReq)
                .when()
                .post("/v3/tags")
                .then()
                .spec(successCreateTagRespSpec)
                .extract().as(CreateTagResp.class);

        assertTrue(createTagResp.getSuccess());
        assertEquals(tagName, createTagResp.getData().getName());
        assertNotNull(createTagResp.getData().getId());
    }

    @Test
    @Epic("Api")
    @Feature("Tag")
    @DisplayName("Создание и удаление тега пользователя")
    public void createUserTagAndDeleteTest() {

        LoginReq loginReq = new LoginReq("sir.nevajn@yandex.ru", "driver_7890");

        LoginResp loginResp = given(loginReqSpec)
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

        RequestSpecification authSpec = TagSpec.createTagSpec(userId, apiToken);

        CreateTagResp createTagResp = given(authSpec)
                .body(createTagReq)
                .when()
                .post("/v3/tags")
                .then()
                .spec(successCreateTagRespSpec)
                .extract().as(CreateTagResp.class);

        assertTrue(createTagResp.getSuccess());
        assertEquals(tagName, createTagResp.getData().getName());
        assertNotNull(createTagResp.getData().getId());

        String tagId = createTagResp.getData().getId();
        DeleteTagReq deleteTagReq = new DeleteTagReq(tagId);

        DeleteTagResp deleteTagResp = given(deleteTagSpec())
                .body(deleteTagReq)
                .when()
                .delete("/v3/tags/" + tagId)
                .then()
                .spec(successDeleteTagRespSpec)
                .extract().as(DeleteTagResp.class);

        assertTrue(deleteTagResp.getSuccess());
    }
}
