package web.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class BaseTest {

    private static final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    public String login = config.login();
    public String password = config.password();

    @BeforeAll
    static void setUp() {

        // ДО создания конфига
        System.out.println("=== BEFORE CONFIG CREATION ===");
        System.out.println("System properties:");
        System.getProperties().forEach((k, v) -> {
            if (k.toString().contains("config") || k.toString().contains("remote")) {
                System.out.println("  " + k + " = " + v);
            }
        });

        // ОТЛАДКА - добавьте в самое начало
        System.out.println("=== DEBUG ===");
        System.out.println("System property 'config': " + System.getProperty("config"));
        System.out.println("config.isRemote(): " + config.isRemote());
        System.out.println("config.remoteUrl(): " + config.remoteUrl());
        System.out.println("config.baseUrl(): " + config.baseUrl());
        System.out.println("config.browser(): " + config.browser());
        System.out.println("==============");

        Configuration.baseUrl = config.baseUrl();
        Configuration.browserSize = config.browserSize();
        Configuration.pageLoadStrategy = config.pageLoadStrategy();
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;

        if (config.isRemote()) {
            System.out.println(">>> RUNNING IN REMOTE MODE <<<");
            Configuration.remote = config.remoteUrl();
            Configuration.browser = config.browser();
            Configuration.browserVersion = "128.0";

            // Проверка URL
            if (config.remoteUrl() == null || config.remoteUrl().isEmpty()) {
                throw new RuntimeException("remote.url is not specified for remote mode!");
            }

            System.out.println("Remote URL: " + config.remoteUrl());

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options",
                    Map.<String, Object>of(
                            "enableVNC", config.vncEnable(),
                            "enableVideo", config.videoEnable(),
                            "enableLog", config.logsEnable()
                    )
            );

            Configuration.browserCapabilities = capabilities;
        } else {
            System.out.println(">>> RUNNING IN LOCAL MODE <<<");
            Configuration.browser = config.browser();
        }
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
