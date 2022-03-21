package com.tunein.mw.conf;

import org.aeonbits.owner.Config;

public interface AppConfig extends Config {

    /**
     * Application configuration
     */

    @Key("app.url")
    @DefaultValue("https://tunein.com")
    String appURL();

    @Key("device.name")
    String deviceName();

    @Key("udid")
    String udid();

    @Key("mobile.os")
    String mobileOS();

    @Key("platform.version")
    String platformVersion();

}