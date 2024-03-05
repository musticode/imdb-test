package com.imdb.imdbtest.page.imdb;

import com.imdb.imdbtest.page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AwardsPage extends BasePage {
    @FindBy(xpath = "//a[contains(.,'Betty Blue')]")
    private WebElement filmTitleButton;

    public AwardsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Scroll down to film")
    public void scrollDownToFilm() {
        scrollDownToElement(filmTitleButton);
    }

    @Step("Select film")
    public void selectFilm() {
        click(filmTitleButton);
    }

}
