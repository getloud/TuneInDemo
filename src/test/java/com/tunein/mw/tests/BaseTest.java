package com.tunein.mw.tests;

import com.google.inject.Inject;
import com.tunein.mw.appium.binds.DriverModule;
import com.tunein.mw.appium.service.AppiumService;
import com.tunein.mw.screens.HamburgerMenuPage;
import com.tunein.mw.screens.HomepagePage;
import com.tunein.mw.screens.NavigationPanel;
import com.tunein.mw.screens.SigninSignupPage;
import com.tunein.mw.testdata.UserProvider;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static com.tunein.mw.appium.driverprovider.AppiumDriverProvider.getAppiumDriver;
import static com.tunein.mw.conf.ConfigLoader.config;
import static com.tunein.mw.screens.BaseScreen.rotateScreen;

@Guice(modules = {DriverModule.class})
public class BaseTest {

    @Inject
    protected AppiumService server;

    @Inject
    protected HomepagePage homePage;

    @Inject
    protected NavigationPanel navigationPanel;

    @Inject
    protected HamburgerMenuPage hamburgerMenuPage;

    @Inject
    protected SigninSignupPage signinSignupPage;

    @Inject
    protected UserProvider userProvider;

    @DataProvider(name = "screenOrientation")
    public static Object[][] screenOrientation() {
        return new Object[][]{
                new Object[]{ScreenOrientation.PORTRAIT},
                new Object[]{ScreenOrientation.LANDSCAPE}
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