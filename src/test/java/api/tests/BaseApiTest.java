package api.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

public class BaseApiTest {

    static Faker faker = new Faker(new Locale("en_AU"));
    private static String tagName = faker.name().firstName();

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://habitica.com";
        RestAssured.basePath = "/api";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
