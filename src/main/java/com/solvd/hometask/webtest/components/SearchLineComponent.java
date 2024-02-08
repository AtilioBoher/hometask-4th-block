package com.solvd.hometask.webtest.components;

import com.solvd.hometask.webtest.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchLineComponent extends AbstractUIObject {

    @FindBy(xpath = ".//a[@class = 'nav-menu-categories-link']")
    private ExtendedWebElement productTypesSelect;

    @FindBy(xpath = ".//input[@class = 'nav-search-input']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = ".//button[@class = 'nav-search-btn']")
    private ExtendedWebElement searchButton;

    public SearchLineComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductTypesSelect() {
        return productTypesSelect;
    }

    public ExtendedWebElement getSearchInput() {
        return searchInput;
    }

    public String getSearchInputPlaceholder() {
        return searchInput.getAttribute("placeholder");
    }

    public void typeSearchInputValue(String value) {
        searchInput.type(value);

    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(getDriver());
    }
}
