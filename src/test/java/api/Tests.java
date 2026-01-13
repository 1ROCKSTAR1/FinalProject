package api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Tests {

        private static final String BASE_URL = "https://habitica.com";
        private static String apiToken;
        private static String userId;

        @BeforeAll
        static void setUp() {
                RestAssured.baseURI = BASE_URL;
                RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        }

        @Test
        @DisplayName("Логин и получение API id и токена")
        void loginAndGetToken() {

                String username = "sir.nevajn@yandex.ru";
                String password = "driver_7890";

                Map<String, String> authResponse = given()
                        .contentType(ContentType.JSON)
                        .body(Map.of(
                                "username", username,
                                "password", password
                        ))
                        .log().all()
                        .when()
                        .post("/api/v3/user/auth/local/login")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("success", equalTo(true))
                        .body("data.apiToken", notNullValue())
                        .body("data.id", notNullValue())
                        .extract()
                        .path("data");

                apiToken = authResponse.get("apiToken");
                userId = authResponse.get("id");

                System.out.println("User ID: " + userId);
                System.out.println("API Token: " + apiToken);

                testAuthentication();
        }

        private void testAuthentication() {
                given()
                        .header("x-api-user", userId)
                        .header("x-api-key", apiToken)
                        .header("X-Client", userId + "-TestApp")
                        .when()
                        .get("/api/v3/user")
                        .then()
                        .statusCode(200)
                        .body("success", equalTo(true))
                        .body("data.id", equalTo(userId));
        }
}

