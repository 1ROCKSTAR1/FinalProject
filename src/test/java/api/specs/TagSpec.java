package api.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class TagSpec {

    public static RequestSpecification createTagSpec(String userId, String apiToken) {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("x-api-user", userId)
                .addHeader("x-api-key", apiToken)
                .addHeader("X-Client", userId + "-TestApp")
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification deleteTagSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

        public static ResponseSpecification successCreateTagRespSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .log(STATUS)
                .log(BODY)
                .build();

    public static ResponseSpecification successDeleteTagRespSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();
    }