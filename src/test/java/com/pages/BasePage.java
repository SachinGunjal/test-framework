package com.pages;

import com.utils.Statik;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;

    @Value("${baseurl}")
    protected String baseURL;

    String driverVersion = System.getProperty("driverversion", "");
    String browserName = System.getProperty("browserName");

    public void initiateDriver() {
        switch (browserName) {
            case "chrome":
                (driverVersion.equals("") ? WebDriverManager.chromedriver() : WebDriverManager.chromedriver().browserVersion(driverVersion)).setup();
                ChromeOptions chromeOptionsDefault = new ChromeOptions();
                chromeOptionsDefault.addArguments("--disable-web-security", "--ignore-certificate-errors", "--start-maximized");
                driver = new ChromeDriver();
                break;
            case "firefox":
                (driverVersion.equals("") ? WebDriverManager.firefoxdriver() : WebDriverManager.firefoxdriver().browserVersion(driverVersion)).setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                (driverVersion.equals("") ? WebDriverManager.edgedriver() : WebDriverManager.edgedriver().browserVersion(driverVersion)).setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected browsername value: " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Statik.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
    }

    public void openApplicationURL() {
        initiateDriver();
        driver.get(baseURL);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement getWebElement(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }


}
