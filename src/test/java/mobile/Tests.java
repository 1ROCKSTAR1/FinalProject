package mobile;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.back;

public class Tests {

    @Test
    public void loginTest() {
        back();

        $x("//android.widget.TextView[@text='Login']").click();
        $x("//android.widget.TextView[@text='Username or email']").sendKeys("sir.nevajn@yandex.ru");
        $x("//android.widget.TextView[@text='Password']").sendKeys("driver_7890");
        $x("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View/android.widget.Button").click();

        $x("//android.widget.TextView[@resource-id='com.habitrpg.android.habitica:id/toolbar_title']").shouldHave(text("sirnevajn"));
    }
}
