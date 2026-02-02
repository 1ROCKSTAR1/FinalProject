package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${config:mobile}.properties")
public interface MobileWikiConfig extends Config {

    @Key("platform.name")
    @DefaultValue("Android")
    String platformName();

    @Key("device.name")
    @DefaultValue("emulator-5554")
    String deviceName();

    @Key("platform.version")
    @DefaultValue("11.0")
    String platformVersion();

    @Key("app.package")
    @DefaultValue("org.wikipedia.alpha")
    String appPackage();

    @Key("app.activity")
    @DefaultValue("org.wikipedia.main.MainActivity")
    String appActivity();

    @Key("remote.url")
    @DefaultValue("http://localhost:4723/")
    String remoteUrl();

    @Key("emulator.app.path")
    @DefaultValue("src/test/resources/apps/app-alpha-universal-release.apk")
    String emulatorAppPath();
}
