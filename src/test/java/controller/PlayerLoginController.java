package controller;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public record PlayerLoginController() {

    private static final String requestBody = "{\n" +
            "  \"grant_type\": \"password\",\n" +
            "  \"username\": \"Ilon_Mas\",\n" +
            "  \"password\": \"amFuZWRvZTEyMw==\" \n}";


    public static Response loginPlayer(){

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
