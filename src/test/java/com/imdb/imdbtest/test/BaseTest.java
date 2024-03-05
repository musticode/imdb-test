package com.imdb.imdbtest.test;

import com.imdb.imdbtest.driver.DriverManager;
import com.imdb.imdbtest.driver.DriverOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Slf4j
public class BaseTest extends DriverManager {

    @BeforeTest
    @Parameters(value = {"browserName"})
    public void init(@Optional String browserName) {

        // to run test class in ide
        if (browserName == null) {
            WebDriverManager.chromedriver().setup();
            log.info("Browser name is null, chrome driver is initializing default");
            driver = new ChromeDriver(DriverOptions.getChromeOptions());
        } else {
            log.info("Browser name {} is initializing", browserName);
            setDriver(browserName);
        }

    }


    @AfterTest
    public void destroy() {
        log.info("Terminating browser");
        terminateBrowser();
    }

}
