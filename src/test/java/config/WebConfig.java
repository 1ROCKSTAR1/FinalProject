package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${config}.properties",
        "classpath:config/web.properties"
})
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("baseUrl")
    @DefaultValue("https://habitica.com")
    String baseUrl();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("page.load.strategy")
    @DefaultValue("eager")
    String pageLoadStrategy();

    @Key("login")
    @DefaultValue("sir.nevajn@yandex.ru")
    String login();

    @Key("password")
    @DefaultValue("driver_7890")
    String password();

    // SELENOID
    @Key("is.remote")
    boolean isRemote();

    //TODO check in a case when there are some errors while remote run
    @Key("remote.url")
    @DefaultValue("")
    String remoteUrl();

    @Key("selenoid.vnc.enable")
    @DefaultValue("true")
    boolean vncEnable();

    @Key("selenoid.video.enable")
    @DefaultValue("true")
    boolean videoEnable();

    @Key("selenoid.logs.enable")
    @DefaultValue("true")
    boolean logsEnable();
}
