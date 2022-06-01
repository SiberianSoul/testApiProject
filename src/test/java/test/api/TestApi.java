package test.api;

import controller.GuestTokenController;
import controller.PlayerLoginController;
import controller.PlayerProfileInfoController;
import controller.RegisterNewPlayerController;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;


public class TestApi {

    @Before
    public void before(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }


    @Test
    @Order(0)
    public void testToken() {
        GuestTokenController.postToken();
    }

    @Test
    @Order(1)
    public void registerNewPlayer() {
        RegisterNewPlayerController.postNewPlayer();
    }

    @Test
    @Order(2)
    public void playerLogin() {
        PlayerLoginController.loginPlayer();
    }

    @Test
    @Order(3)
    public void getPlayerInfo() {
        PlayerProfileInfoController.getPlayerInfo("1");
    }

    @Test
    @Order(4)
    public void getAnotherPlayerInfo() {
        PlayerProfileInfoController.getPlayerInfo("787yguy6");
    }


}
