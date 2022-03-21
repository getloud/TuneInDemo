package com.tunein.mw.screens;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.SoftAssertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.tunein.mw.conf.ConfigLoader.config;

public class HamburgerMenuPage extends  BaseScreen {

        private SelenideElement logo = $x("//*[@id='tuneInLogo']");
        private SelenideElement signinButton = $x("//*[@data-testid='sidebarLogin']");
        private SelenideElement signupButton = $x("//*[@data-testid='sidebarSignUp']");
        private ElementsCollection menuItems = $$x("//*[contains(@class, 'leftSide-module__navigationMenuItem')]");
        private SelenideElement libraryButton = $x("//*[@data-testid='favorites']");
        private SelenideElement settingsButton = $x("//*[@data-testid='account']");
        private SelenideElement logoutButton = $x("//*[@data-testid='logout']");

        @Override
        public HamburgerMenuPage waitUntilPageLoaded() {
            menuItems.shouldHave(CollectionCondition.sizeGreaterThan(0),Duration.ofSeconds(config().waitShortTimeoutSeconds()));
            return this;
        }

        public void clickOnMenuItem(String name) {
            jsClick($x(String.format( "//*[contains(@class, 'leftSide-module__navigationMenuItem') and contains(text(), '%s')]", name)));
        }

        public HamburgerMenuPage checkIfUserLoogedIn(){
            SoftAssertions assertion = new SoftAssertions();
            assertion.assertThat(libraryButton.is(Condition.visible)).as("Library button is not displayed").isTrue();
            assertion.assertThat(settingsButton.is(Condition.visible)).as("Settings button is not displayed").isTrue();
            assertion.assertThat(logoutButton.is(Condition.visible)).as("Logout button is not displayed").isTrue();
            assertion.assertThat(signinButton.is(Condition.visible)).as("Signin button is  displayed").isFalse();
            assertion.assertAll();
            return this;
        }

        public void clickSignInButton() {
            jsClick(signinButton);
        }

        public void clickSignUpButton() {

            jsClick(signupButton);
        }

        public void clickLogoutButton() {
            jsClick(logoutButton);
    }


}
