package com.imdb.imdbtest.page.imdb.film;

import com.imdb.imdbtest.page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class FilmDetailPage extends BasePage {

    @FindBy(xpath = "(//li[contains(@role,'presentation')])[9]")
    private WebElement directorElement;

    @FindBy(xpath = "(//li[contains(@role,'presentation')])[11]")
    private WebElement firstWriterElement;

    @FindBy(xpath = "(//li[contains(@role,'presentation')])[12]")
    private WebElement secondWriterElement;

    @FindBy(xpath = "(//li[contains(@role,'presentation')])[14]")
    private WebElement firstStarElement;

    @FindBy(xpath = "(//li[contains(@role,'presentation')])[15]")
    private WebElement secondStarElement;

    @FindBy(xpath = "(//li[contains(@role,'presentation')])[16]")
    private WebElement thirdStarElement;


    private Set<String> directors = new HashSet<>();
    private Set<String> writers = new HashSet<>();
    private Set<String> stars = new HashSet<>();

    public FilmDetailPage(WebDriver driver) {
        super(driver);
    }

    @Step("Saving film details")
    public void saveFilmDetails(){
        directors.add(getText(directorElement));
        writers.add(getText(firstWriterElement));
        writers.add(getText(secondWriterElement));
        stars.add(getText(firstStarElement));
        stars.add(getText(secondStarElement));
        stars.add(getText(thirdStarElement));

        directors.forEach(item -> System.out.println("Director" + item));
        writers.forEach(item -> System.out.println("Writer" + item));
        stars.forEach(item -> System.out.println("Star : " + item));

    }

    @Step("Director information matched")
    public boolean directorInformationMatched() {
        return directors.contains(getText(directorElement));
    }

    @Step("Writer information matched")
    public boolean writerInformationMatched() {
        boolean allMatched = false;

        if (checkWriter(getText(firstWriterElement)) && checkWriter(getText(secondWriterElement))){
            allMatched = true;
        }

        return allMatched;
    }

    @Step("Star information matched")
    public boolean starInformationMatched() {

        boolean allMatched = false;
        if (checkStar(getText(firstStarElement)) && checkStar(getText(secondStarElement)) && checkStar(getText(thirdStarElement))){
            allMatched = true;
        }

        return allMatched;
    }

    private boolean checkWriter(String writer){
        return writers.contains(writer);
    }

    private boolean checkStar(String star){
        return stars.contains(star);
    }
}
