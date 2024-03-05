package com.imdb.imdbtest.config;

import org.aeonbits.owner.Config;
@org.aeonbits.owner.Config.Sources({
        "file:./src/test/resources/application.properties"}
)
public interface TestPropertyConfig extends Config {

    @Key("timeout.duration")
    int timeOutDuration();

}
