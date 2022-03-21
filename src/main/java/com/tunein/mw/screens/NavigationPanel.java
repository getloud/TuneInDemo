package com.tunein.mw.screens;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.tunein.mw.screens.BaseScreen.jsClick;

public class NavigationPanel {

    private SelenideElement searchButton = $x("//*[@id='search-icon-use']");
    private SelenideElement hamburgerMenuButton = $x("//*[@id='sidebarToggle']");
    private SelenideElement logo = $x("//*[@id='tuneInLogo']");

    public NavigationPanel openHamburgerMenu() {
        jsClick(hamburgerMenuButton);
        return this;
    }

    public NavigationPanel clickSearchButton() {
        jsClick(searchButton);
        return this;
    }

}
