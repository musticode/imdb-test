package com.imdb.imdbtest.page.imdb;

import com.imdb.imdbtest.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OscarsPage extends BasePage {

    @FindBy(xpath = "//div[@class='ipc-title ipc-title--base ipc-title--subsection-title ipc-title--on-textPrimary ipc-title--p-none']//a[@class='ipc-title-link-wrapper']")
    private WebElement eventHistoryButton;

    @FindBy(xpath = "//li[normalize-space()='1980s']")
    private WebElement years1980Element;


    @FindBy(xpath = "//a[contains(.,'1987')]")
    private WebElement year1987Element;

    public OscarsPage(WebDriver driver) {
        super(driver);
    }

    public void scrollToEventHistory() {
        scrollDownToElement(eventHistoryButton);
        properWait(2000);
        click(years1980Element);
        click(year1987Element);
        properWait(2000);
    }

}
