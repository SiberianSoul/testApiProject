package controller;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public record PlayerProfileInfoController() {

    private static String bearerToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImY0YjVkYzg1NmU5YWY3YTEzNWYxZjg0NGYzNTljZWMzOTAxNGIzY2NiMjNhOTU1ZjUwYjgxOGY5MDEyOGMwZGYxOTVlMDk2NWE0ZTRlNWZiIn0.eyJhdWQiOiJmcm9udF8yZDZiMGE4MzkxNzQyZjVkNzg5ZDdkOTE1NzU1ZTA5ZSIsImp0aSI6ImY0YjVkYzg1NmU5YWY3YTEzNWYxZjg0NGYzNTljZWMzOTAxNGIzY2NiMjNhOTU1ZjUwYjgxOGY5MDEyOGMwZGYxOTVlMDk2NWE0ZTRlNWZiIiwiaWF0IjoxNjUzODI0Mjc3LCJuYmYiOjE2NTM4MjQyNzcsImV4cCI6MTY1MzkxMDY3Nywic3ViIjoiMTM1MTUiLCJzY29wZXMiOlsiYm9udXM6cmVhZCIsImdhbWU6cmVhZCIsImdhbWVfaGlzdG9yeTpyZWFkIiwiamFja3BvdDpyZWFkIiwicGF5bWVudDpyZWFkIiwicGxheWVyOnJlYWQiLCJ3aW5uZXI6cmVhZCIsImNhc2lubzpyZWFkIiwibWVzc2FnZTpyZWFkIiwiZmFxOnJlYWQiLCJsb3lhbHR5OnJlYWQiLCJnYW1lOndyaXRlIiwicGF5bWVudDp3cml0ZSIsInBsYXllcjp3cml0ZSIsIm1lc3NhZ2U6d3JpdGUiXX0.fzG0ovajqZpWCgvsGXnUhQINqaJ4F8ZTWpIrFnEMVW6SPIPZ00llrHXhPmFsg3zL4DxWIIq-mln22N1wdExef52egArIC06whEVC3N9WANJYu-XMm_Fbjqn4RMd9PgSaKDzdsnbG-bstadFlUajhqDQwAqZRQARnlRpyYjXWKTM";

    public static Response getPlayerInfo(String id){

        return given().headers(
                "Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON
        )
                .param("id",id)
                .when()
                .get("http://test-api.d6.dev.devcaz.com/v2/players")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

}
