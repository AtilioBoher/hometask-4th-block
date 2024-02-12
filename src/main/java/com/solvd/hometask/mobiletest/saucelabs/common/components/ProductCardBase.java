package com.solvd.hometask.mobiletest.saucelabs.common.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductCardBase extends AbstractUIObject {

    public ProductCardBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getPriceTagText();
}
