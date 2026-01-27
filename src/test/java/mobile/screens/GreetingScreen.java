package mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class GreetingScreen {

    private SelenideElement skipButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Skip']"));

    public LoginScreen clickOnSkip() {
        skipButton.click();
        return new LoginScreen();
    }
}
