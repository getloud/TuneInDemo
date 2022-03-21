package com.tunein.mw.appium.driverprovider;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.ios.options.wda.XcodeCertificate;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.tunein.mw.conf.ConfigLoader.config;

@ParametersAreNonnullByDefault
public class IOSDriverProvider implements WebDriverProvider {

    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(Capabilities capabilities) {
        XCUITestOptions options = new XCUITestOptions();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        options.setPlatformName("iOS");
        options.setDeviceName(config().deviceName());
        options.setPlatformVersion(config().platformVersion());
        options.setNewCommandTimeout(Duration.ofSeconds(config().newCommandTimeout()));
        options.withBrowserName("Safari");
        options.setWebviewConnectTimeout(Duration.ofSeconds(5000));
        options.setUdid(config().udid());
        options.setUseNewWDA(true);
        options.setXcodeCertificate(new XcodeCertificate("iPhone Developer","UA4R9ZQWLZ"));

        try {
            return new IOSDriver(new URL(String.format("http://%s:%s/wd/hub", config().appiumHost(), config().appiumPort())), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
    }


