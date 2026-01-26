package api.tests;

import api.models.*;
import api.specs.TagSpec;
import data.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.specs.LoginUserSpec.loginReqSpec;
import static api.specs.LoginUserSpec.statusCodeSpec;
import static api.specs.TagSpec.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Tag("api")
public class TagTests extends BaseApiTest {

    TestData testData = new TestData();

    @Test
    @Epic("Api")
    @Feature("Tag")
    @DisplayName("Creating a user's tag")
    public void createUserTagTest() {
        step("Create a request", ()-> {
            LoginReq loginReq = new LoginReq("sir.nevajn@yandex.ru", "driver_7890");

            LoginResp loginResp = given(loginReqSpec)
                    .body(loginReq)
                    .when()
                    .post("/v3/user/auth/local/login")
                    .then()
                    .spec(statusCodeSpec(200))
                    .extract().as(LoginResp.class);

            String userId = loginResp.getData().getId();
            String apiToken = loginResp.getData().getApiToken();

            step("Create a tag and check a final response", ()-> {
                CreateTagReq createTagReq = new CreateTagReq(testData.tagName);

                RequestSpecification authSpec = TagSpec.createTagSpec(userId, apiToken);

                CreateTagResp createTagResp = given(authSpec)
                        .body(createTagReq)
                        .when()
                        .post("/v3/tags")
                        .then()
                        .spec(successCreateTagRespSpec)
                        .extract().as(CreateTagResp.class);


                assertTrue(createTagResp.getSuccess());
                assertEquals(testData.tagName, createTagResp.getData().getName());
                assertNotNull(createTagResp.getData().getId());
            });

        });
    }

    @Test
    @Epic("Api")
    @Feature("Tag")
    @DisplayName("Creating and deleting a user's tag")
    public void createUserTagAndDeleteTest() {

        step("Create a request", ()-> {
            LoginReq loginReq = new LoginReq("sir.nevajn@yandex.ru", "driver_7890");

            LoginResp loginResp = given(loginReqSpec)
                    .body(loginReq)
                    .when()
                    .post("/v3/user/auth/local/login")
                    .then()
                    .spec(statusCodeSpec(200))
                    .extract().as(LoginResp.class);

            String userId = loginResp.getData().getId();
            String apiToken = loginResp.getData().getApiToken();

            step("Create and delete a new tag", ()-> {
                CreateTagReq createTagReq = new CreateTagReq(testData.tagName);

                RequestSpecification authSpec = TagSpec.createTagSpec(userId, apiToken);

                CreateTagResp createTagResp = given(authSpec)
                        .body(createTagReq)
                        .when()
                        .post("/v3/tags")
                        .then()
                        .spec(successCreateTagRespSpec)
                        .extract().as(CreateTagResp.class);

                assertTrue(createTagResp.getSuccess());
                assertEquals(testData.tagName, createTagResp.getData().getName());
                assertNotNull(createTagResp.getData().getId());


                String tagId = createTagResp.getData().getId();
                DeleteTagReq deleteTagReq = new DeleteTagReq(tagId);

                RequestSpecification deleteTagSpec = TagSpec.deleteTagSpec(userId, apiToken);
                DeleteTagResp deleteTagResp = given(deleteTagSpec)
                        .body(deleteTagReq)
                        .when()
                        .delete("/v3/tags/" + tagId)
                        .then()
                        .spec(successDeleteTagRespSpec)
                        .extract().as(DeleteTagResp.class);

                assertTrue(deleteTagResp.getSuccess());
            });

        });
    }
}
