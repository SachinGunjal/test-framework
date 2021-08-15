package com.steps;

import com.pages.CategoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class WishlistPageSteps extends BaseSteps {

    @When("Customer views wishlist table")
    public void customerViewsWishlistTable() {
        wishlistPage.clickWishListIcon();
        Assert.assertTrue(wishlistPage.isWishlistPageDisplayed(), "Wishlist page has not been displayed correctly");
    }

    @Then("Customer should be able to find the selected items in the wishlist")
    public void customerShouldBeAbleToFindTheSelectedItemsInTheWishlist() {
        Assert.assertTrue(wishlistPage.compareItems(CategoryPage.productNames, wishlistPage.getWishlistedProducts()), "Wishlist does not contain the same items as Selected items.");
    }

    @When("Customer searches for the lowest price item in the wishlist")
    public void customerSearchesForTheLowestPriceItemInTheWishlist() {
        wishlistPage.getLowPricedProduct();
        wishlistPage.getLowPriceProductName();
    }

    @And("Customer adds the lowest price item to the cart from wishlist")
    public void customerAddsTheLowestPriceItemToTheCartFromWishlist() {
        wishlistPage.addLowPricedProduct();
    }
}
