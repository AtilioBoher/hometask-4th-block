package com.solvd.hometask.mobiletest.saucelabs.android;

import com.solvd.hometask.mobiletest.saucelabs.common.MainPageBase;
import com.solvd.hometask.mobiletest.saucelabs.android.components.ProductCard;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-PRODUCTS']")
    private ExtendedWebElement productsWindow;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private List<ExtendedWebElement> productCards;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price' and @text='$29.99']")
    private ExtendedWebElement priceTag;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getAllPriceTags() {
        List<String> priceTags = new ArrayList<>();
        for (ExtendedWebElement productCard : productCards) {
            priceTags.add(productCard.getText());
        }
        swipe(productsWindow, Direction.DOWN);
        for (ExtendedWebElement productCard : productCards) {
            priceTags.add(productCard.getText());
        }
        return priceTags;
    }

    @Override
    public String getPriceTag() {
        return priceTag.getText();
    }


}
