package com.solvd.hometask.mobiletest.carina.android;

import com.solvd.hometask.mobiletest.carina.common.InitPageBase;
import com.solvd.hometask.mobiletest.carina.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = InitPageBase.class)
public class InitPage extends InitPageBase {

    @FindBy(id = "carina_logo")
    private ExtendedWebElement logo;

    @FindBy(id = "next_button")
    private ExtendedWebElement nextBtn;

    public InitPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    @Override
    public boolean isNextBtnPresent() {
        return nextBtn.isElementPresent();
    }

    @Override
    public LoginPageBase clickNextBtn() {
        nextBtn.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

}
