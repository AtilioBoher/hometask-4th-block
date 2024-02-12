package com.solvd.hometask.mobiletest.saucelabs.android;

import com.solvd.hometask.mobiletest.saucelabs.common.LoginPageBase;
import com.solvd.hometask.mobiletest.saucelabs.common.MainPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private ExtendedWebElement userNameInputField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private ExtendedWebElement userPasswordInputField;

    @FindBy(xpath = "//android.widget.TextView[@text='LOGIN']")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isUserNameInputFieldPresent() {
        return userNameInputField.isElementPresent();
    }

    @Override
    public boolean isUserPasswordInputFieldPresent() {
        return userPasswordInputField.isElementPresent();
    }

    @Override
    public boolean isLoginBtnPresent() {
        return loginBtn.isElementPresent();
    }

    @Override
    public MainPageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), MainPageBase.class);
    }

    @Override
    public void typeUserName(String name) {
        userNameInputField.type(name);
    }

    @Override
    public void typeUserPassword(String password) {
        userPasswordInputField.type(password);
    }

    @Override
    public MainPageBase login() {
        String username = "standard_user";
        String password = "secret_sauce";
        typeUserName(username);
        typeUserPassword(password);
        return clickLoginBtn();
    }


}
