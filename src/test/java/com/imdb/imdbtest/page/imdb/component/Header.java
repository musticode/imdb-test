package com.imdb.imdbtest.page.imdb.component;

import com.imdb.imdbtest.page.BasePage;
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

    public void clickImdbButton(){
        click(imdbHomeButtonElement);
    }

    public void clickMenuButton(){
        click(menuButtonElement);
    }

    public void clickOscars(){
        click(oscarsElement);
    }

    public void setTextToSearchInput(String searchText){
        setText(suggestionSearchInputElement, searchText);
    }

    public void selectFilmToNavigateFilmDetailsPage(){
        setArrowDownKeysToElement(suggestionSearchInputElement);
        setEnterToElement(suggestionSearchInputElement);
    }


}
