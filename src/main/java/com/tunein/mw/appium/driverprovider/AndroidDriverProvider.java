package com.tunein.mw.appium.driverprovider;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.net.URL;

import static com.tunein.mw.conf.ConfigLoader.config;

public class AndroidDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setDeviceName("Android Test");
        options.setUdid(config().udid());
        options.setPlatformVersion("9.0");
        options.withBrowserName("Chrome");
        options.setChromedriverExecutable("/usr/local/bin/chromedriver");
        try {
            return new AndroidDriver(new URL(String.format("http://%s:%s/wd/hub", config().appiumHost(), config().appiumPort())), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}


