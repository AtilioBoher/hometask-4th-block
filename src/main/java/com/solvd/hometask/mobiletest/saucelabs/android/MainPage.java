package com.solvd.hometask.mobiletest.saucelabs.android;

import com.solvd.hometask.mobiletest.saucelabs.common.MainPageBase;
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

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private List<ExtendedWebElement> priceTags;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getAllPrices() {
        List<String> prices = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (ExtendedWebElement priceTag : priceTags) {
                prices.add(priceTag.getText());
            }
            swipeUp(2, 400);
        }
        return prices;
    }
}
