package com.pages;

import com.utils.Sleeper;
import com.utils.Statik;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryPage extends BasePage {

    public static List<String> productNames;

    private final String ADD_TO_WISHLIST = ".//*[contains(@class,'add_to_wishlist')]";
    private final String ADDED_TO_WISHLIST = ".//*[contains(@class,'feedback')]";
    private final String ADDED_PRODUCT_NAMES = ".//*[contains(@class,'feedback')]/ancestor::li/a/h2";


    public boolean isShopPageDisplayed() {
        return getPageTitle().contains(Statik.SHOP_CATEGORY_TITLE);
    }

    public int addToWishlist(int itemCount) {
        driver.findElements(By.xpath(ADD_TO_WISHLIST)).stream().limit(itemCount).forEach(i -> {
            i.click();
            Sleeper.sleep(1000);
        });
        return driver.findElements(By.xpath(ADDED_TO_WISHLIST)).size();
    }

    public void getAddedProductsNames() {
        productNames = driver.findElements(By.xpath(ADDED_PRODUCT_NAMES)).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
