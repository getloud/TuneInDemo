package com.tunein.mw.appium.binds;

import com.codeborne.selenide.Configuration;
import com.google.inject.AbstractModule;
import com.tunein.mw.appium.driverprovider.AndroidDriverProvider;
import com.tunein.mw.appium.driverprovider.IOSDriverProvider;

import static com.tunein.mw.conf.ConfigLoader.config;

public class DriverModule extends AbstractModule {

    public static final String ANDROID = "android";
    public static final String IOS = "ios";

    @Override
    protected void configure() {
        switch (config().mobileOS()) {
            case ANDROID ->
                    com.codeborne.selenide.Configuration.browser = AndroidDriverProvider.class.getName();
            case IOS ->
                    com.codeborne.selenide.Configuration.browser = IOSDriverProvider.class.getName();
        }
        com.codeborne.selenide.Configuration.browserSize = null;
    }
}
