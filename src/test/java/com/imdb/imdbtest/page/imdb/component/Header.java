package com.imdb.imdbtest.page.imdb.component;

import com.imdb.imdbtest.page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {
    @FindBy(css = "#home_img_holder")
    private WebElement imdbHomeButtonElement;

    @FindBy(id = "imdbHeader-navDrawerOpen")
    private WebElement menuButtonElement;

    @FindBy (xpath = "//a[@role='menuitem'][contains(.,'Oscars')]")
    private WebElement oscarsElement;

    @FindBy (id = "suggestion-search")
    private WebElement suggestionSearchInputElement;

    public Header(WebDriver driver) {
        super(driver);
    }

    @Step("Clicking IMDB button")
    public void clickImdbButton(){
        click(imdbHomeButtonElement);
    }

    @Step("Clicking Menu button")
    public void clickMenuButton(){
        click(menuButtonElement);
    }

    @Step("Clicking Oscars")
    public void clickOscars(){
        click(oscarsElement);
    }

    @Step("Enter input to search field")
    public void setTextToSearchInput(String searchText){
        setText(suggestionSearchInputElement, searchText);
    }

    @Step("Select film to navigate film details")
    public void selectFilmToNavigateFilmDetailsPage(){
        setArrowDownKeysToElement(suggestionSearchInputElement);
        setEnterToElement(suggestionSearchInputElement);
    }


}
