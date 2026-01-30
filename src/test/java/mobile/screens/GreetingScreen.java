package mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class GreetingScreen {

    private SelenideElement skipButton = $(AppiumBy.xpath("//android.widget.Button[@resource-id='com.habitrpg.android.habitica:id/skipButton']"));

    public SignupLoginScreen clickOnSkip() {
        skipButton.click();
        return new SignupLoginScreen();
    }
}
