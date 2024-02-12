package com.solvd.hometask.mobiletest.carina.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class InitPageBase extends AbstractPage {

    public InitPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLogoPresent();

    public abstract boolean isNextBtnPresent();

    public abstract LoginPageBase clickNextBtn();

}
