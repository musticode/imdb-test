package com.imdb.imdbtest.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverOptions {

    private static ChromeOptions chromeOptions;
    private static FirefoxOptions firefoxOptions;

    public static ChromeOptions getChromeOptions() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        firefoxOptions = new FirefoxOptions();
        return firefoxOptions;
    }

}
