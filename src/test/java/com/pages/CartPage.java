package com.pages;

import com.utils.Statik;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.pages.WishlistPage.lowestProductName;

public class CartPage extends BasePage {

    private static final String SHOPPING_CART = "(.//*[contains(@class,'la la-shopping-bag')])[1]";
    private static final String PRODUCT_NAME = ".//*[contains(@class,'product-name')]/a";
    private static final String PRODUCT_ADDED = ".//*[contains(@class,'woocommerce-message')]";

    public void clickShoppingCart() {
        getWebElement(SHOPPING_CART).click();
    }

    public boolean isShoppingCartPageDisplayed() {
        return getPageTitle().contains(Statik.CART_PAGE_TITLE);
    }

    public String getAddedProductName() {
        return getWebElement(PRODUCT_NAME).getText();
    }

    public boolean verifyAddedProductInCart() {
        return getAddedProductName().equalsIgnoreCase(lowestProductName);
    }

    public void waitUntilProductAddedToCart() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(PRODUCT_ADDED), Statik.CART_SUCCESSFUL_MESSAGE));
    }
}
