package com.solvd.hometask.mobiletest.carina.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isNameInputFieldPresent();

    public abstract boolean isPasswordInputFieldPresent();

    public abstract boolean isMaleRadioBtnPresent();

    public abstract boolean isFemaleRadioBtnPresent();

    public abstract boolean isPrivacyPolicyCheckboxPresent();

    public abstract boolean isLoginBtnPresent();


}
