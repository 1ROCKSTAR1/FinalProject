package api.tests;

import config.ApiConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    protected static ApiConfig config = ConfigFactory.create(ApiConfig.class);

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = config.baseUri();
        RestAssured.basePath = config.basePath();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
