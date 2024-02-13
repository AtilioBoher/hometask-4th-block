package com.solvd.hometask.mobiletest.saucelabs.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class MainPageBase extends AbstractPage {
    public MainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> getAllPrices();
}
