package api.tests;

import api.models.LoginReq;
import api.models.LoginResp;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class LoginTests extends BaseApiTest{

        private static String apiToken;
        private static String userId;

        LoginReq loginReq = new LoginReq("sir.nevajn@yandex.ru","driver_7890");

        @Test
        @Epic("Api")
        @Feature("Login")
        @DisplayName("Логин и получение API id и токена")
        void loginAndGetTokenTest() {

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

                LoginResp.Data data = loginResp.getData();

                assertThat(loginResp.getSuccess(), equalTo(true));
                assertThat(data.getId(), notNullValue());
                assertThat(data.getApiToken(), notNullValue());

                userId = data.getId();
                apiToken = data.getApiToken();
        }
}