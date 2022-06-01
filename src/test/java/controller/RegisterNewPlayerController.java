package controller;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;

public record RegisterNewPlayerController() {
    private static final String requestBody = "{\n" +
            "  \"username\": \"Ilon_Mas\",\n" +
            "  \"password_change\": \"amFuZWRvZTEyMw==\",\n" +
            "  \"password_repeat\": \"amFuZWRvZTEyMw==\",\n" +
            "  \"email\": \"ilon_mas@email.com\",\n" +
            "  \"name\": \"ilon\",\n" +
            "  \"surname\": \"mask\" \n}";

    private static final String bearerToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjZlMzAwN2MxY2FjMDkxNjJhNGRjNmU1MGY0NTNlMjZmY2YzZDRiODFhZTMxYzdhNmE3YjlmYWQzNjE0OTJhMmM3NGUzNzM3MDdlZWI5MjVlIn0.eyJhdWQiOiJmcm9udF8yZDZiMGE4MzkxNzQyZjVkNzg5ZDdkOTE1NzU1ZTA5ZSIsImp0aSI6IjZlMzAwN2MxY2FjMDkxNjJhNGRjNmU1MGY0NTNlMjZmY2YzZDRiODFhZTMxYzdhNmE3YjlmYWQzNjE0OTJhMmM3NGUzNzM3MDdlZWI5MjVlIiwiaWF0IjoxNjUzODE5ODgxLCJuYmYiOjE2NTM4MTk4ODEsImV4cCI6MTY1MzkwNjI4MSwic3ViIjoiIiwic2NvcGVzIjpbImd1ZXN0OmRlZmF1bHQiXX0.G3rrOwNxqLY9KU3ltQkTufOVZeub4LJw-TXj26lV9vq4hbZGYY8W8ghhZZ0-1CU3M-szkqbtSSi1T_DBTLLr0nAZtgwTxKhu4Pk_SdMxW0xT-i6W0QbYNFlWjD9QBIAG4sYgIuTAz8jN7Ap6nqBkpM_oLfwgMG7OPsJ1orNno9o";

    public static Response postNewPlayer(){

        return given().headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON
                )
                .and()
                .body(requestBody)
                .when()
                .post("http://test-api.d6.dev.devcaz.com/v2/players")
                .then()
                .statusCode(201)
                .extract().response();
    }
}
