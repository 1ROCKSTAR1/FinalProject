package mobile;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class EmulatorDriver implements WebDriverProvider {

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        // Базовые настройки
        options.setCapability("platformName", "Android");
        options.setCapability("appium:automationName", "UiAutomator2");

        // Локальные настройки
        options.setCapability("appium:appPackage", "com.habitrpg.android.habitica");
        options.setCapability("appium:appActivity", "com.habitrpg.android.habitica.ui.activities.MainActivity");
        options.setCapability("appium:deviceName", "emulator-5554");
        options.setCapability("appium:platformVersion", "11.0");
        options.setCapability("appium:autoGrantPermissions", true);
        options.setCapability("appium:noReset", false);
        options.setCapability("appium:fullReset", false);

        // Если есть локальный APK файл
        File app = new File("src/test/resources/apps/Habitica-2209014510-prod-release.apk");
        if (app.exists()) {
            options.setCapability("appium:app", app.getAbsolutePath());
        }

        try {
            URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");
            return new AndroidDriver(appiumServerUrl, options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
