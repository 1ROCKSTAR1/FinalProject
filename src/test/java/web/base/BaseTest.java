package web.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    public String login = "sir.nevajn@yandex.ru";
    public String password = "driver_7890";

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://habitica.com/login";
        Configuration.browserSize = "1920x1200";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;

    }

    @BeforeEach
    void beforeSingle() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void tearDown() {

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
