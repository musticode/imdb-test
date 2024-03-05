package com.imdb.imdbtest.test.imdb;

import com.imdb.imdbtest.constant.TestConstant;
import com.imdb.imdbtest.page.imdb.AwardsPage;
import com.imdb.imdbtest.page.imdb.HomePage;
import com.imdb.imdbtest.page.imdb.OscarsPage;
import com.imdb.imdbtest.page.imdb.film.FilmDetailPage;
import com.imdb.imdbtest.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ImdbTest extends BaseTest {

    HomePage homePage;
    OscarsPage oscarsPage;
    AwardsPage awardsPage;
    FilmDetailPage filmDetailPage;


    @Test
    public void checkFilmDetailsTest(){

        homePage = new HomePage(driver);
        oscarsPage = new OscarsPage(driver);
        awardsPage = new AwardsPage(driver);
        filmDetailPage = new FilmDetailPage(driver);

        homePage.navigateToMainPage();
        homePage.navigateToOscars();

        oscarsPage.scrollToEventHistory();

        awardsPage.scrollDownToFilm();
        awardsPage.selectFilm();

        filmDetailPage.saveFilmDetails();

        homePage.returnToMainPage();
        homePage.search(TestConstant.FILM_NAME);

        Assert.assertTrue(
                filmDetailPage.directorInformationMatched(),
                "Director information are not matched"
        );

        Assert.assertTrue(
                filmDetailPage.writerInformationMatched(),
                "Writer information are not matched"
        );

        Assert.assertTrue(
                filmDetailPage.starInformationMatched(),
                "Star information are not matched"
        );

    }

}
