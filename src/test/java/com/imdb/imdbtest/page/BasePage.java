package com.imdb.imdbtest.page;

import com.imdb.imdbtest.config.TestPropertyConfig;
import com.imdb.imdbtest.exception.ElementNotFoundException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Slf4j
public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    TestPropertyConfig config = ConfigFactory.create(TestPropertyConfig.class);


    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(config.timeOutDuration()));
        js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    private void waitFor(WebElement element){
        try {
            log.info("Waiting for element : {}", element.toString());
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (ElementNotFoundException e){
            log.info("Element not found : {}", e.getMessage());
        }

    }

    public void properWait(long duration){
        try {
            Thread.sleep(duration);
        }catch (InterruptedException e) {
            log.warn("Interrupted exception {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void click(WebElement element){
        waitFor(element);
        element.click();
        log.info("Clicking element {}", element.getAccessibleName());
    }

    public void setText(WebElement element, String text){
        waitFor(element);
        element.clear();
        element.sendKeys(text);
        log.info("Sending keys : {} to element : {}",text, element.toString());
    }

    public List<WebElement> findElements(By locator){
        List<WebElement> elementList = driver.findElements(locator);
        return elementList;
    }

    public boolean isElementDisplayed(WebElement element){
        waitFor(element);
        return element.isDisplayed();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void getPage(String url){
        if (!url.isEmpty() && !url.isBlank()){
            log.info("Getting url : {}", url);
            driver.get(url);
        }
    }

    public void setArrowDownKeysToElement(WebElement element){
        waitFor(element);
        log.info("Arrow down to element : {}", element.toString());
        element.sendKeys(Keys.ARROW_DOWN);
    }

    public void setEnterToElement(WebElement element){
        waitFor(element);
        log.info("Set enter to element : {}", element.toString());
        element.sendKeys(Keys.ENTER);
    }

    public String getText(WebElement element){
        waitFor(element);
        log.info("Get text of element : {}",element.toString());
        return element.getText();
    }

    public void scrollDown(){
        js.executeScript("window.scrollBy(0,600)");
        log.info("Scroll down 600");
    }

    public void scrollDownByValue(int value){
        String script = "window.scrollBy(0,"+ value + ")";
        js.executeScript(script);
        log.info("Scroll down with value {}", value);
    }

    public void scrollDownToEndOfPage(){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        js.executeScript(script);
        log.info("Scroll down to end of page");
    }

    public void scrollDownToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
        log.info("Scrolling down to element");
    }


}
