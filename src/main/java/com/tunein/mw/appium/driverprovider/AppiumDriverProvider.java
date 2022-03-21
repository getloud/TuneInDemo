package com.tunein.mw.appium.driverprovider;

import io.appium.java_client.AppiumDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AppiumDriverProvider  {

    public static AppiumDriver getAppiumDriver() {
        return (AppiumDriver) getWebDriver();
    }

}