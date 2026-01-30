package mobile.tests;

import io.appium.java_client.AppiumBy;
import mobile.base.BaseEmulatorTest;
import mobile.screens.GreetingScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("mobile")
public class Tests extends BaseEmulatorTest {

    GreetingScreen greetingScreen = new GreetingScreen();

    private String login = "sir.nevajn@yandex.ru";

    private String pass = "driver_7890";

    @Test
    @DisplayName("The first initial test with POM")
    public void loginTestWithPOM() {

        String userNickname = greetingScreen
                .clickOnSkip()
                .checkLoginScreen()
                .clickLoginButton()
                .fillLogin(login)
                .fillPassword(pass)
                .clickOnSubmitLoginButton()
                .getUserName();

        Assertions.assertEquals(login,userNickname);
    }
}
