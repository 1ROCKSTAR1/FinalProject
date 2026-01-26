package api.tests;

import api.models.EmptyFieldResp;
import api.models.LoginReq;
import api.models.LoginResp;
import api.models.NonExistResp;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.specs.LoginUserSpec.*;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Tag("api")
public class LoginTests extends BaseApiTest {

        private static String apiToken;
        public static String userId;

        LoginReq loginReq = new LoginReq("sir.nevajn@yandex.ru", "driver_7890");
        LoginReq loginNonExistReq = new LoginReq("sir.nevaj@yandex.ru", "driver_7890");
        LoginReq loginEmptyNameReq = new LoginReq("", "driver_7890");
        LoginReq loginEmptyPasswordReq = new LoginReq("sir.nevajn@yandex.ru", "");

        @Test
        @Epic("Api")
        @Feature("Login")
        @DisplayName("Login and getting API ID and token")
        void loginAndGetTokenTest() {
                step("Create a request", () -> {
                        LoginResp loginResp = given(loginReqSpec)
                                .body(loginReq)
                                .when()
                                .post("/v3/user/auth/local/login")
                                .then()
                                .spec(statusCodeSpec(200))
                                .extract().as(LoginResp.class);

                        LoginResp.Data data = loginResp.getData();

                        userId = data.getId();
                        apiToken = data.getApiToken();

                        step("Checking a response", () -> {
                                assertThat(loginResp.getSuccess(), equalTo(true));
                                assertThat(data.getId(), notNullValue());
                                assertThat(data.getApiToken(), notNullValue());
                        });
                });
        }

        @Test
        @Epic("Api")
        @Feature("Login")
        @DisplayName("Login with non-existent user")
        void loginNonExistentUserTest() {

                step("Create a request", () -> {
                        NonExistResp loginNonExistResp = given(loginReqSpec)
                                .body(loginNonExistReq)
                                .when()
                                .post("/v3/user/auth/local/login")
                                .then()
                                .spec(statusCodeSpec(401))
                                .extract().as(NonExistResp.class);


                        step("Check a response", () -> {
                                assertThat(loginNonExistResp.getSuccess(), equalTo(false));
                                assertThat(loginNonExistResp.getError(), equalTo("NotAuthorized"));
                                assertThat(loginNonExistResp.getMessage(), notNullValue());
                        });
                });
        }

        @Test
        @Epic("Api")
        @Feature("Login")
        @DisplayName("Login with an empty name")
        void loginEmptyNameUserTest() {

                step("Create a request", () -> {
                        EmptyFieldResp loginEmptyNameResp = given(loginReqSpec)
                                .body(loginEmptyNameReq)
                                .when()
                                .post("/v3/user/auth/local/login")
                                .then()
                                .spec(statusCodeSpec(400))
                                .extract().as(EmptyFieldResp.class);

                        EmptyFieldResp.Error error = loginEmptyNameResp.getErrors().get(0);

                        step("Check a response", () -> {
                                assertThat(loginEmptyNameResp.getSuccess(), equalTo(false));
                                assertThat(loginEmptyNameResp.getError(), equalTo("BadRequest"));
                                assertThat(loginEmptyNameResp.getMessage(), equalTo("Invalid request parameters."));

                                assertThat(error.getMessage(), equalTo("Missing username or email."));
                                assertThat(error.getParam(), equalTo("username"));
                        });

                });
        }

        @Test
        @Epic("Api")
        @Feature("Login")
        @DisplayName("Login with an empty password")
        void loginEmptyPasswordUserTest() {

                step("Create a request", () -> {
                        EmptyFieldResp loginEmptyPassResp = given(loginReqSpec)
                                .body(loginEmptyPasswordReq)
                                .when()
                                .post("/v3/user/auth/local/login")
                                .then()
                                .spec(statusCodeSpec(400))
                                .extract().as(EmptyFieldResp.class);

                        EmptyFieldResp.Error error = loginEmptyPassResp.getErrors().get(0);

                        step("Check a response", () -> {
                                assertThat(loginEmptyPassResp.getSuccess(), equalTo(false));
                                assertThat(loginEmptyPassResp.getError(), equalTo("BadRequest"));
                                assertThat(loginEmptyPassResp.getMessage(), equalTo("Invalid request parameters."));

                                assertThat(error.getMessage(), equalTo("Missing password."));
                                assertThat(error.getParam(), equalTo("password"));
                        });
                });
        }
}