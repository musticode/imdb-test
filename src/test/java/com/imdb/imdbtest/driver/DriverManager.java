package com.imdb.imdbtest.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.chromium.ChromiumDriverCommandExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public WebDriver driver;

    public WebDriver setDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver(DriverOptions.getChromeOptions());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver(DriverOptions.getFirefoxOptions());
                break;
            default:
                WebDriverManager.edgedriver().setup();
                this.driver = new EdgeDriver(new EdgeOptions());
                break;
        }

        return driver;
    }

    public void terminateBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
