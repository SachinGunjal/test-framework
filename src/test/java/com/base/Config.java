package com.base;

import com.pages.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/**
 * This class will hold all the beans(Page Objects) needed.
 */
@Configuration
@PropertySource("file:src/test/resources/env/env-${env:dev}.properties")
public class Config {

    @Bean
    @Scope("cucumber-glue")
    BasePage basePage() {
        return new BasePage();
    }

    @Bean
    @Scope("cucumber-glue")
    HomePage homePage() {
        return new HomePage();
    }

    @Bean
    @Scope("cucumber-glue")
    CategoryPage categoryPage() {
        return new CategoryPage();
    }

    @Bean
    @Scope("cucumber-glue")
    CartPage cartPage() {
        return new CartPage();
    }

    @Bean
    @Scope("cucumber-glue")
    WishlistPage wishlistPage() {
        return new WishlistPage();
    }
}
