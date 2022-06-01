package controller;

import helper.Spec;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public record GuestTokenController() {
    private static final String requestBody = "{\n" +
            "  \"grant_type\": \"client_credentials\",\n" +
            "  \"scope\": \"guest:default\" \n}";


    public static Response postToken(){

        return given()
                .auth()
                .preemptive()
                .basic("front_2d6b0a8391742f5d789d7d915755e09e", "")
                .contentType(ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .post("http://test-api.d6.dev.devcaz.com/v2/oauth2/token")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

}
