package com.steps;

import io.cucumber.java.en.And;
import org.testng.Assert;

public class CategoryPageSteps extends BaseSteps {

    @And("Customer added {int} different items to the wishlist")
    public void customerAddedDifferentItemsToTheWishlist(int itemCount) {
        Assert.assertEquals(categoryPage.addToWishlist(itemCount), itemCount);
        categoryPage.getAddedProductsNames();
    }
}
