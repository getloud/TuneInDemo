package com.tunein.mw.appium.driverprovider;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;


public class AppiumDriverProvider  {

    public static AppiumDriver getAppiumDriver() {
            return (AppiumDriver) WebDriverRunner.getWebDriver();
    }

}