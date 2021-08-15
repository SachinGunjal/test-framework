package com.pages;

import com.utils.Statik;

public class HomePage extends BasePage {


    private static final String ACCEPT_COOKIES = ".//*[contains(text(),'Accept all')][1]";
    private static final String SHOP_CATEGORY = ".//*[@title='Shop']";


    public boolean isHomePageDisplayed() {
        return getPageTitle().contains(Statik.HOME_PAGE_TITLE);
    }

    public void selectShopCategory(String category) {
        switch (category) {  /* other categories can be included as other cases like shop, sale */
            case "shop":
                getWebElement(SHOP_CATEGORY).click();
                break;
            default:
                throw new IllegalStateException("Unexpected Category value: " + category);
        }
    }

    public void acceptCookies() {
        getWebElement(ACCEPT_COOKIES).click();
    }
}
