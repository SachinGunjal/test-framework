package com.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartPageSteps extends BaseSteps {

    @Then("Customer should be able to verify the item in cart")
    public void customerShouldBeAbleToVerifyTheItemInCart() {
        Assert.assertTrue(cartPage.verifyAddedProductInCart(), "Selected Product has not been added in the cart");
    }

    @And("Customer navigates to cart")
    public void customerNavigatesToCart() {
        cartPage.waitUntilProductAddedToCart();
        cartPage.clickShoppingCart();
        Assert.assertTrue(cartPage.isShoppingCartPageDisplayed(), "Cart page has not been loaded correctly");
    }
}
