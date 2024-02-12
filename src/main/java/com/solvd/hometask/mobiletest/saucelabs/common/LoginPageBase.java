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

    public abstract MainPageBase clickLoginBtn();

    public abstract void typeUserName(String name);

    public abstract void typeUserPassword(String password);

    public abstract MainPageBase login();

}
