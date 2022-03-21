package com.tunein.mw.tests.homepage;

import com.tunein.mw.screens.HamburgerMenuPage;
import com.tunein.mw.screens.HomepagePage;
import com.tunein.mw.screens.NavigationPanel;
import com.tunein.mw.screens.SigninSignupPage;
import com.tunein.mw.testdata.UserProvider;
import com.tunein.mw.tests.BaseTest;
import org.testng.annotations.Test;

public class HomePageViewTest extends BaseTest {

    HomepagePage homePage = new HomepagePage();
    NavigationPanel navigationPanel = new NavigationPanel();
    HamburgerMenuPage hamburgerMenuPage = new HamburgerMenuPage();
    SigninSignupPage signinSignupPage = new SigninSignupPage();
    UserProvider userProvider = new UserProvider();

    @Test(description = "Verify main home page elements")
    public void checkHomePage() {
        homePage
                .clickOnCloseLandingPageButton()
                .waitUntilPageLoaded()
                .verifyHomePageContainsAllElements();
    }

    @Test(description = "Verify login flow")
    public void checkLoginFlow() {
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