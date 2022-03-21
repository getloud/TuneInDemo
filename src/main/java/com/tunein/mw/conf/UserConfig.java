package com.tunein.mw.conf;

import org.aeonbits.owner.Config;

public interface UserConfig extends Config {

    @Key("no.subs.user.email")
    @DefaultValue("lezvinskii@gmail.com")
    String noSubsUserEmail();

    @Key("no.subs.user.password")
    @DefaultValue("Wood3333")
    String noSubsUserPassword();

}
