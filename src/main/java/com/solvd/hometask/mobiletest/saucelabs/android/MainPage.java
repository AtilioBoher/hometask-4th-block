package com.solvd.hometask.mobiletest.saucelabs.android;

import com.solvd.hometask.mobiletest.saucelabs.common.MainPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {


    public MainPage(WebDriver driver) {
        super(driver);
    }


}
