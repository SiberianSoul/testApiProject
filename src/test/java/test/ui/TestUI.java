package test.ui;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class TestUI {

    private final SelenideElement loginField = $(byId("UserLogin_username"));
    private final SelenideElement passwordField = $(byId("UserLogin_password"));
    private final SelenideElement loginButton = $(byClassName("btn-primary"));
    private final SelenideElement columnName = $(byId("payment-system-transaction-grid_c1"));


    @Test
    @Order(0)
    public void loginTest(){

        open("http://test-app.d6.dev.devcaz.com/admin/login");

        element(loginField).setValue("admin1");
        element(passwordField).setValue("[9k<k8^z!+$$GkuP");
        element(loginButton).click();
    }

    @Test
    @Order(1)
    public void sortTest(){
        open("http://test-app.d6.dev.devcaz.com/user/player/admin");
        element(columnName).click();
    }

}
