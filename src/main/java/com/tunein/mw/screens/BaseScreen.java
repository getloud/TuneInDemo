package com.tunein.mw.screens;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;
import static com.tunein.mw.appium.driverprovider.AppiumDriverProvider.getAppiumDriver;

public abstract class BaseScreen {

     public abstract <T extends BaseScreen> T waitUntilPageLoaded();


    public static void jsClick(SelenideElement element){
            JavascriptExecutor executor = (JavascriptExecutor) getAppiumDriver();
            executor.executeScript("arguments[0].click();", element);
    }

    }
