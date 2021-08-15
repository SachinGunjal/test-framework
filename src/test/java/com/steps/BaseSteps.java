package com.steps;

import com.pages.*;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseSteps {

    @Autowired
    public BasePage basePage;

    @Autowired
    public HomePage homePage;

    @Autowired
    public CartPage cartPage;

    @Autowired
    public WishlistPage wishlistPage;

    @Autowired
    public CategoryPage categoryPage;

}
