package com.tunein.mw.tests.homepage;

import com.tunein.mw.tests.BaseTest;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

import static com.tunein.mw.screens.BaseScreen.rotateScreen;

public class HomePageViewTest extends BaseTest {

    @Test(description = "Verify main home page elements", dataProvider = "screenOrientation")
    public void checkHomePage(ScreenOrientation orientation) {
        rotateScreen(orientation);
        homePage
                .clickOnCloseLandingPageButton()
                .waitUntilPageLoaded()
                .verifyHomePageContainsAllElements();
    }

    @Test(description = "Verify login flow", dataProvider = "screenOrientation")
    public void checkLoginFlow(ScreenOrientation orientation) {
        rotateScreen(orientation);
        navigationPanel
                .openHamburgerMenu();
        hamburgerMenuPage
                .waitUntilPageLoaded()
                .clickSignInButton();
        signinSignupPage
                .waitUntilPageLoaded()
                .typeUsername(userProvider.USER_EMAIL)
                .typePassword(userProvider.USER_PASSWORD)
                .clickSignInButton();
        homePage
                .waitUntilPageLoaded();
        navigationPanel
                .openHamburgerMenu();
        hamburgerMenuPage
                .checkIfUserLoogedIn()
                .clickLogoutButton();
    }
}
