package com.solvd.hometask.webtest;

import com.solvd.hometask.webtest.components.ProductCard;
import com.solvd.hometask.webtest.components.SearchLineComponent;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class HomePageTest extends AbstractTest {

    @Test
    public void verifySearchLineTest() {
        String brandName = "Lenovo";
        List<String> keyWords = Arrays.asList("Notebook", "Thinkpad");

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();

        HomePage page = new HomePage(driver);
        page.open();

        SearchLineComponent searchLineComponent = page.getHeader().getSearchLineComponent();
        sa.assertTrue(searchLineComponent.getProductTypesSelect().isElementPresent(1),
                "Product type select is not present");
        Assert.assertTrue(searchLineComponent.getSearchInput().isElementPresent(1),
                "Search input is not present");
        // the expected String is on spanish, it means: "Search products, brands and more…"
        sa.assertEquals(searchLineComponent.getSearchInputPlaceholder(),
                "Buscar productos, marcas y más…",
                "Search input has an incorrect placeholder");
        Assert.assertTrue(searchLineComponent.getSearchButton().isElementPresent(1),
                "Search button is not present");

        searchLineComponent.typeSearchInputValue(brandName);
        SearchPage searchPage = searchLineComponent.clickSearchButton();

        sa.assertTrue(driver.getCurrentUrl().toLowerCase().contains(brandName.toLowerCase()),
                "Url doesn't contain the brand name");

        checkThatProductsHaveTheBrandNameOrKeyword(searchPage, sa, brandName, keyWords);

        sa.assertAll();
    }

    private static void checkThatProductsHaveTheBrandNameOrKeyword(SearchPage searchPage, SoftAssert sa, String brandName, List<String> keywords) {
        List<ProductCard> cards = searchPage.getCards();
        for (ProductCard card : cards) {
            sa.assertTrue(checkForBrandNameOrKeyword(brandName, card, keywords),
                    String.format(
                            "Product with name '%s' doesn't contain the brand name in its title", card.getTitleText()
                    ));
        }
    }

    private static boolean checkForBrandNameOrKeyword(String brandName, ProductCard card, List<String> keywords) {
        if (card.getTitleText().toLowerCase().contains(brandName.toLowerCase())) {
            return true;
        }
        for (String keyword : keywords) {
            if (card.getTitleText().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
