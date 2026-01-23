package config;

import org.aeonbits.owner.Config;


@Config.Sources("classpath:${config:api}.properties")
public interface ApiConfig extends Config{

    @Key("baseUri")
    @DefaultValue("https://habitica.com")
    String baseUri();

    @Key("basePath")
    @DefaultValue("/api")
    String basePath();
}
