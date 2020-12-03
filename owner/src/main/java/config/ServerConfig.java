package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:config.properties")
public interface ServerConfig extends Config {

    @Key("url_otus")
    String url_otus();

    @Key("url_otus_about")
    String url_otus_about();

    @Key("login")
    String login();

    @Key("password")
    String password();
}
