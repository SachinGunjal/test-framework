package com.utils;

import com.pages.BasePage;
import io.cucumber.java.After;

public class Hooks extends BasePage {

    @After
    public void afterTest() {
        driver.quit();
    }
}
