package com.tunein.mw.appium.service;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

import static com.tunein.mw.conf.ConfigLoader.config;

public class AppiumService {

    private static AppiumDriverLocalService service;

    public void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File(config().appiumJsPath()))
                   .usingDriverExecutable(new File("/usr/local/bin/node"))
                    .usingPort(config().appiumPort())

                    .withArgument(GeneralServerFlag.RELAXED_SECURITY)
                    .withArgument(GeneralServerFlag.ALLOW_INSECURE, "true")
                    .withArgument(GeneralServerFlag.LOG_LEVEL, config().appiumLogLevel());


        service = AppiumDriverLocalService.buildService(builder);
        service.withBasePath("/wd/hub/");
        service.start();
        }

    public void stopServer() {
        service.stop();
    }
}
