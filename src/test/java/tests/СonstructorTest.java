package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yandex.stellarburgers.pageObject.MainPageStellarBurgersSelenide;

import static com.codeborne.selenide.Selenide.open;


public class СonstructorTest extends Config {

    MainPageStellarBurgersSelenide mainPage;
    @Before
    public void setUp() {
        mainPage = open("https://stellarburgers.nomoreparties.site/",
                MainPageStellarBurgersSelenide.class);
    }
    @Test
    @DisplayName("Go to the sauces section")
    @Description("User can go to sauces section, clicking on it")
    public void goToSaucesTest() {
        mainPage.saucesSectionClick();
        Assert.assertTrue("Традиционный галактический соус не отображается!", mainPage.isTraditionalGalacticSauceDisplayed());
    }
    @Test
    @DisplayName("Go to the buns section")
    @Description("User can go to buns section, clicking on it")
    public void goToBunsTest() {
        mainPage.fillingsSectionClick();
        mainPage.bunsSectionClick();
        Assert.assertTrue("Булка R2D3 не отображается!", mainPage.isR2D3BunDisplayed());
    }
    @Test
    @DisplayName("Go to the fillings section")
    @Description("User can go to filling section, clicking on it")
    public void goToFillingsTest() {
        mainPage.fillingsSectionClick();
        Assert.assertTrue("Cыр с астероидной плесенью не отображается!", mainPage.isCheeseWithAsteroidMoldDisplayed());
    }
    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
