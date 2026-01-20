package mobile;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Tests extends BaseEmulatorTest {

    @Test
    @DisplayName("The first initial test without POM")
    public void loginTest() {

        $(AppiumBy.xpath("//android.widget.TextView[@text='Skip']")).click();
        $(AppiumBy.xpath("//android.widget.TextView[@text='Login']")).click();
        $(AppiumBy.xpath("//android.widget.TextView[@text='Username or email']")).sendKeys("sir.nevajn@yandex.ru");
        $(AppiumBy.xpath("//android.widget.TextView[@text='Password']")).sendKeys("driver_7890");
        $(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View/android.widget.Button")).click();

        $(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.habitrpg.android.habitica:id/toolbar_title']")).shouldHave(text("sirnevajn"));
    }
}
