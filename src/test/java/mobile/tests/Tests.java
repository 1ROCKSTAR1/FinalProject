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
    @DisplayName("The first initial test without POM")
    public void loginTest() {

        step("Skip greeting screen", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@text='Skip']")).click();
        });

        step("Filling the login field", () -> {
        $(AppiumBy.xpath("//android.widget.TextView[@text='Login']")).click();
        $(AppiumBy.xpath("//android.widget.TextView[@text='Username or email']")).sendKeys("sir.nevajn@yandex.ru");
        });

        step("Filling the password field", () -> {
                    $(AppiumBy.xpath("//android.widget.TextView[@text='Password']")).sendKeys("driver_7890");
                    $(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View/android.widget.Button")).click();
                });

        step("Check the user's profile shown", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.habitrpg.android.habitica:id/toolbar_title']")).shouldHave(text("sirnevajn"));
        });
    }

    @Test
    @DisplayName("The first initial test with POM")
    public void loginTestWithPOM() {

        String userNickname = greetingScreen
                .clickOnSkip()
                .clickOnLoginField()
                .fillLogin(login)
                .fillPassword(pass)
                .clickOnSubmitLoginButton()
                .getUserName();

        Assertions.assertEquals(login,userNickname);
    }
}
