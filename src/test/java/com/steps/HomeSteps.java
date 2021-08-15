package com.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class HomeSteps extends BaseSteps {

    @Given("Customer navigated to Demo Shop homepage")
    public void customerNavigatedToDemoShopHomepage() {
        homePage.openApplicationURL();
        homePage.acceptCookies();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page has not been displayed correctly");
    }

    @And("Customer navigated to {string} section on the homepage")
    public void customerNavigatedToShopSectionOnTheHomepage(String categoryName) {
        homePage.selectShopCategory(categoryName);
        Assert.assertTrue(categoryPage.isShopPageDisplayed(), "Shop section on Homepage has not been displayed correctly");
    }
}
