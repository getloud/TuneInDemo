package com.tunein.mw.conf;

import org.aeonbits.owner.Config;

public interface AppiumConfig extends Config {

    @Key("appium.js.path")
    @DefaultValue("/usr/local/lib/node_modules/appium/build/lib/main.js")
    String appiumJsPath();

    @Key("appium.host")
    @DefaultValue("localhost")
    String appiumHost();

    @Key("appium.port")
    @DefaultValue("4723")
    int appiumPort();

    @Key("appium.log.level")
    @DefaultValue("debug")
    String appiumLogLevel();

    @Key("use.new.wda")
    @DefaultValue("false")
    boolean useNewWDA();

    @Key("new.command.timeout")
    @DefaultValue("120")
    int newCommandTimeout();
}

