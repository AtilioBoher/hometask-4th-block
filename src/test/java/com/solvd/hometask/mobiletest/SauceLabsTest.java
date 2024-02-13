package com.solvd.hometask.mobiletest;

import com.solvd.hometask.mobiletest.saucelabs.common.LoginPageBase;
import com.solvd.hometask.mobiletest.saucelabs.common.MainPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SauceLabsTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Atilio")
    public void testElementsFromLoginPage() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(loginPage.isUserNameInputFieldPresent(), "User name input field is not present");
        sa.assertTrue(loginPage.isUserPasswordInputFieldPresent(), "User password input field is not present");
        sa.assertTrue(loginPage.isUserPasswordInputFieldPresent(), "LOGIN button is not present");
        sa.assertAll();
    }

    @Test()
    @MethodOwner(owner = "Atilio")
    public void testMainPagePrices() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        MainPageBase mainPage = loginPage.login();
        List<String> productPrices = mainPage.getAllPrices();
        for (String price : productPrices) {
            Assert.assertTrue(price.contains("$"), String.format("Price %s, doesn't contain the dollar sign", price));
        }
    }

}
