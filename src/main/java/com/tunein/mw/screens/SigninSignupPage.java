package com.tunein.mw.screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$x;
import static com.tunein.mw.conf.ConfigLoader.config;

public class SigninSignupPage extends BaseScreen{

    private SelenideElement loginByGoogleButton = $x("//*[@id='googleOauthButton']");
    private SelenideElement loginByFacebookButton = $x("//*[@id='facebookOauthButton']");
    private SelenideElement loginByAppleButton = $x("//*[@id='appleSignInOauthButton']");
    private SelenideElement usernameField = $x("//*[@data-testid='usernameEmail']");
    private SelenideElement passwordField = $x("//*[@data-testid='password']");
    private SelenideElement signInButton = $x("//*[@id='signInButton']");


    @Override
    public SigninSignupPage waitUntilPageLoaded() {
        loginByGoogleButton.should(Condition.visible, Duration.ofSeconds(config().waitShortTimeoutSeconds()));
        return this;
    }

    public SigninSignupPage typeUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public SigninSignupPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public SigninSignupPage clickSignInButton() {
        jsClick(signInButton.shouldBe(enabled));
        return this;
    }





}
