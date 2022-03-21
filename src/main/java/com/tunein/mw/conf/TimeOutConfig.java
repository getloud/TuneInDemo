package com.tunein.mw.conf;

import org.aeonbits.owner.Config;

public interface TimeOutConfig extends Config {

    @Key("element.wait.short.timeout.seconds")
    @DefaultValue("10")
    int waitShortTimeoutSeconds();

}