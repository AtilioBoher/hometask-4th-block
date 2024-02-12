package com.solvd.hometask.mobiletest.saucelabs.android.components;

import com.solvd.hometask.mobiletest.saucelabs.common.components.ProductCardBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ProductCardBase.class)
public class ProductCard extends ProductCardBase {

    @FindBy(xpath = ".//*[@content-desc='test-Price']")
    private ExtendedWebElement priceTag;

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public String getPriceTagText() {
        return priceTag.getText();
    }
}
