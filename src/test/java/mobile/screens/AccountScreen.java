package mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class AccountScreen {

    private SelenideElement usersNickname = $(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.habitrpg.android.habitica:id/toolbar_title']"));

    public String getUserName() {
        return usersNickname.getText();
    }
}
