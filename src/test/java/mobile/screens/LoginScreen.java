package mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class LoginScreen {

    private SelenideElement loginField = $(AppiumBy.xpath("//android.widget.TextView[@text='Login']")),
    loginTextField = $(AppiumBy.xpath("//android.widget.TextView[@text='Username or email']")),
    passField = $(AppiumBy.xpath("//android.widget.TextView[@text='Password']")),
    submitButtonLogin = $(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View/android.widget.Button"));

    public LoginScreen clickOnLoginField() {
        loginField.click();
        return this;
    }

    public LoginScreen fillLogin(String name) {
        loginTextField.sendKeys(name);
        return this;
    }

    public LoginScreen fillPassword(String pass) {
        passField.sendKeys(pass);
        return this;
    }

    public AccountScreen clickOnSubmitLoginButton() {
        submitButtonLogin.click();
        return new AccountScreen();
    }

}
