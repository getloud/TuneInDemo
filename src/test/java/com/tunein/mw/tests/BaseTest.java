package com.tunein.mw.tests;

import com.tunein.mw.appium.binds.DriverModule;
import com.tunein.mw.appium.service.AppiumService;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static com.tunein.mw.appium.driverprovider.AppiumDriverProvider.getAppiumDriver;
import static com.tunein.mw.conf.ConfigLoader.config;

@Guice(modules = {DriverModule.class})
public class BaseTest {

    protected AppiumService server = new AppiumService();

    @DataProvider(name = "screenOrientation")
    public static Object[][] screenOrientation() {
        return new Object[][]{
                new Object[]{ScreenOrientation.LANDSCAPE},
                new Object[]{ScreenOrientation.PORTRAIT}
        };
    }

    @BeforeSuite
    public void beforeSuite() {
        server.startServer();
    }

    @BeforeClass
    public void beforeClass() {
        open(config().appURL());
    }


    @AfterClass
    public void afterClass(){
            getAppiumDriver().quit();
    }

    @AfterSuite
    public void afterSuite() {
            server.stopServer();
    }

}