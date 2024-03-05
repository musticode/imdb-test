package com.imdb.imdbtest.page.imdb;

import com.imdb.imdbtest.constant.TestConstant;
import com.imdb.imdbtest.page.BasePage;
import com.imdb.imdbtest.page.imdb.component.Header;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    @FindBy(xpath = "//button[contains(.,'Accept')]")
    private WebElement acceptPreferenceButton;

    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
    }


    @Step("Get IMDB Main Page")
    public void navigateToMainPage(){
        getPage(TestConstant.MAIN_PAGE_URL);
        handlePreferences();
    }

    @Step("Navigate to Oscars Page")
    public void navigateToOscars(){
        header.clickMenuButton();
        header.clickOscars();
    }

    @Step("Search fim in search field")
    public void search(String searchText){
        header.setTextToSearchInput(searchText);
        properWait(1000);
        header.selectFilmToNavigateFilmDetailsPage();
    }

    @Step("Return to main page via clicking IMDB button")
    public void returnToMainPage(){
        header.clickImdbButton();
    }

    private void handlePreferences(){
        click(acceptPreferenceButton);
    }



}
