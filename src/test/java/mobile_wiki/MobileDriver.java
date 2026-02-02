package mobile_wiki;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileWikiConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class MobileDriver implements WebDriverProvider {

    private static final MobileWikiConfig config =
            ConfigFactory.create(MobileWikiConfig.class, System.getProperties());

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(config.platformName())
                .setPlatformVersion(config.platformVersion())
                .setDeviceName(config.deviceName())
                .setApp(getAppPath())
                .setAppPackage(config.appPackage())
                .setAppActivity(config.appActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

        public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        String appVersion = "app-alpha-universal-release.apk";
        String appUrl = "https://github.com/wikimedia/apps-android-wikipedia" +
                "/releases/download/latest/" + appVersion;
        String appPath = "src/test/resources/apps/" + appVersion;

        File app = new File(appPath);
        if(!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download app", e);
            }
        }
        return app.getAbsolutePath();
    }
}
