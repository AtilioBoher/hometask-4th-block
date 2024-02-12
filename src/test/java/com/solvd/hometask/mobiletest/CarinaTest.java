package com.solvd.hometask.mobiletest;

import com.solvd.hometask.mobiletest.carina.common.InitPageBase;
import com.solvd.hometask.mobiletest.carina.common.LoginPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CarinaTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Atilio")
    public void testElementsFromInitPage() {
        InitPageBase initPage = initPage(getDriver(), InitPageBase.class);
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(initPage.isNextBtnPresent(), "Logo is not present");
        sa.assertTrue(initPage.isNextBtnPresent(), "Next button is not present");
        sa.assertAll();
    }

    @Test()
    @MethodOwner(owner = "Atilio")
    public void testElementsFromLoginPage() {
        InitPageBase initPage = initPage(getDriver(), InitPageBase.class);
        Assert.assertTrue(initPage.isNextBtnPresent(), "Next button is not present on he screen");
        LoginPageBase loginPage = initPage.clickNextBtn();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(loginPage.isNameInputFieldPresent(), "Name input field is not present");
        sa.assertTrue(loginPage.isPasswordInputFieldPresent(), "Password input field is not present");
        sa.assertTrue(loginPage.isMaleRadioBtnPresent(), "Male button is not present");
        sa.assertTrue(loginPage.isFemaleRadioBtnPresent(), "Female button is not present");
        sa.assertTrue(loginPage.isPrivacyPolicyCheckboxPresent(), "Privacy policy checkbox is not present");
        sa.assertTrue(loginPage.isLoginBtnPresent(), "Login button is not present");
        sa.assertAll();
    }

}
