package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/web.properties")
public interface WebConfig extends Config {

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
}
