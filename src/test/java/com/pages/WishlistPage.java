package com.pages;

import com.utils.Statik;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WishlistPage extends BasePage {

    private static final String WISHLIST = ".//*[contains(@class,'lar la-heart')]";
    private static final String WISHLIST_PRODUCTS = ".//*[contains(@class,'product-name')]";
    private static final String WISHLIST_PRODUCTS_PRICE = ".//*[contains(@class,'product-price')]/ins/span/bdi";
    private static final String LOW_PRICE_PRODUCT = ".//*[contains(text(),'%s')]/parent::td/following-sibling::td[3]/a";
    private static final String LOW_PRICE_PRODUCT_NAME = "(.//*[contains(text(),'%s')])[3]/parent::span/parent::ins/parent::td/preceding-sibling::td[1]";
    public static String lowestProductName;
    public static int lowestProductPrice;

    public boolean isWishlistPageDisplayed() {
        return getPageTitle().contains(Statik.WISHLIST_PAGE_TITLE);
    }

    public void clickWishListIcon() {
        getWebElement(WISHLIST).click();
    }

    public List<String> getWishlistedProducts() {
        return driver.findElements(By.xpath(WISHLIST_PRODUCTS)).stream().skip(1).map(WebElement::getText).collect(Collectors.toList());
    }

    public void getLowPricedProduct() {
        List<String> itemPrices = driver.findElements(By.xpath(WISHLIST_PRODUCTS_PRICE)).stream().map(WebElement::getText).collect(Collectors.toList());
        List<Integer> priceIntegerOnly = new ArrayList<>();
        for (String s : itemPrices) {
            priceIntegerOnly.add(Integer.parseInt(s.replaceAll("£", "").replace(".00", "")));
        }
        lowestProductPrice = priceIntegerOnly.stream().mapToInt(value -> value).min().orElse(Integer.MAX_VALUE);
    }

    public void addLowPricedProduct() {
        driver.findElement(By.xpath(String.format(LOW_PRICE_PRODUCT, lowestProductName))).click();
    }

    public void getLowPriceProductName() {
        lowestProductName = driver.findElement(By.xpath(String.format(LOW_PRICE_PRODUCT_NAME, lowestProductPrice))).getText();
    }

    public boolean compareItems(List<String> wishlistProduct, List<String> categoryProduct) {
        return compareLists(wishlistProduct, categoryProduct);
    }

    private boolean compareLists(List<String> A, List<String> B) {
        Collections.sort(A);
        Collections.sort(B);
        return A.equals(B);
    }

}
