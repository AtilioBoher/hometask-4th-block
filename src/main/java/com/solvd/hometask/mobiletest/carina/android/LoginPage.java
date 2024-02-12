package com.solvd.hometask.mobiletest.carina.android;

import com.solvd.hometask.mobiletest.carina.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(id = "name")
    private ExtendedWebElement nameInputField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInputField;

    @FindBy(id = "radio_male")
    private ExtendedWebElement maleRadioBtn;

    @FindBy(id = "radio_female")
    private ExtendedWebElement femaleRadioBtn;

    @FindBy(id = "checkbox")
    private ExtendedWebElement privacyPolicyCheckbox;

    @FindBy(id = "login_button")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isNameInputFieldPresent() {
        return nameInputField.isElementPresent();
    }

    @Override
    public boolean isPasswordInputFieldPresent() {
        return passwordInputField.isElementPresent();
    }

    @Override
    public boolean isMaleRadioBtnPresent() {
        return maleRadioBtn.isElementPresent();
    }

    @Override
    public boolean isFemaleRadioBtnPresent() {
        return femaleRadioBtn.isElementPresent();
    }

    @Override
    public boolean isPrivacyPolicyCheckboxPresent() {
        return privacyPolicyCheckbox.isElementPresent();
    }

    @Override
    public boolean isLoginBtnPresent() {
        return loginBtn.isElementPresent();
    }


}
