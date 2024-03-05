package com.imdb.imdbtest.listener;

import com.imdb.imdbtest.driver.DriverManager;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestListener extends DriverManager implements ITestListener {

    /**
     * Test Listener methods
     */

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test started : {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Success : {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.warn("Failure : {}", result.getName());
        saveScreenshotPNG(driver);
        saveTextLog(result.getTestName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("Test skipped: : {}", result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("Started at : {}", System.currentTimeMillis());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("Finished at : {}", System.currentTimeMillis());
    }


    /**
     * Allure Attachment annotations
     *
     * @param driver
     */
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }


    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }


}
