package com.solvd.hometask.mobiletest.saucelabs.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isUserNameInputFieldPresent();

    public abstract boolean isUserPasswordInputFieldPresent();

    public abstract boolean isLoginBtnPresent();
}
