package com.tunein.mw.screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.TimeoutException;
import org.assertj.core.api.SoftAssertions;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.tunein.mw.conf.ConfigLoader.config;

public class HomepagePage extends BaseScreen{

    private SelenideElement closeLandingPageButton = $x("//*[@id='closeButtonTitle']/..");
    private SelenideElement listenNowButton = $x("//*[@id='homeStartListeningButton1']/span");
    private ElementsCollection podcastCategories = $$x("//*[contains(@class, 'parallax-headers-module__parallaxScrollContainer')]");
    private SelenideElement homePageDescription = $x("//*[contains(@class, 'landing-module__textSection')]");


    @Override
    public HomepagePage waitUntilPageLoaded() {
        listenNowButton.shouldBe(Condition.visible, Duration.ofSeconds(config().waitShortTimeoutSeconds()));
        return this;
    }


    public HomepagePage clickOnCloseLandingPageButton() {
        try {
            closeLandingPageButton.click();
        } catch (TimeoutException | ElementNotFound ex) {
        }
        return this;

    }

    public HomepagePage verifyHomePageContainsAllElements (){
        SoftAssertions assertion = new SoftAssertions();
        assertion.assertThat(listenNowButton.is(Condition.visible)).as("Listen now button is not displayed").isTrue();
        assertion.assertThat(homePageDescription.is(Condition.visible)).as("Homepage description is not displayed").isTrue();
        assertion.assertThat(podcastCategories.isEmpty()).as("Podcast Categories are not uploaded").isFalse();
        assertion.assertAll();
        return this;
    }
}
