package com.solvd.hometask.webtest;

import com.solvd.hometask.webtest.components.ProductCard;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//li[@class = 'ui-search-layout__item']")
    private List<ProductCard> Cards;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductCard> getCards() {
        return Cards;
    }
}
