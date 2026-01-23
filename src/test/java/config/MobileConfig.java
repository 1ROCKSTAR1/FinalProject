package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${config:mobile}.properties")
public interface MobileConfig extends Config {

    @Key("platform.name")
    @DefaultValue("android")
    String platformName();

    @Key("device.name")
    @DefaultValue("emulator-5554")
    String deviceName();

    @Key("platform.version")
    @DefaultValue("11.0")
    String platformVersion();

    @Key("app.package")
    @DefaultValue("com.habitrpg.android.habitica")
    String appPackage();

    @Key("app.activity")
    @DefaultValue("com.habitrpg.android.habitica.ui.activities.MainActivity")
    String appActivity();
}
