package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yandex.stellarburgers.pageObject.LoginPageStellarBurgersSelenide;
import yandex.stellarburgers.pageObject.MainPageStellarBurgersSelenide;
import yandex.stellarburgers.pageObject.PersonalProfilePageStellarBurgersSelenide;

import static com.codeborne.selenide.Selenide.open;

public class GoToMainPageFromProfileTest extends Config {

    MainPageStellarBurgersSelenide mainPage;
    LoginPageStellarBurgersSelenide loginPage;
    PersonalProfilePageStellarBurgersSelenide profilePage;
    String email = "simpson@yandex.ru";
    String password = "qweQWE123";

    @Before
    public void setUp() {
        mainPage = open("https://stellarburgers.nomoreparties.site/",
                MainPageStellarBurgersSelenide.class);
        loginPage = mainPage.personalAccWithoutAuthButtonClick();
        loginPage.login(email, password);
        profilePage = mainPage.personalAccWithAuthButtonClick();

    }
    @Test
    @DisplayName("Go to main page from profile page")
    @Description("User can go to the constructor on the main page from the button 'Constructor' on the header of profile page")
    public void goToMainPageThroughConstructorButtonTest() {
        mainPage = profilePage.constructorButtonClick();
        Assert.assertTrue("Заголовок главной страницы не отображается", mainPage.isMainPageHeaderDisplayed());
    }
    @Test
    @DisplayName("Go to main page from logo header")
    @Description("User can go to the constructor on the main page from the logo on the header of profile page")
    public void goToMainPageThroughLogoTest() {
        mainPage = profilePage.logoClick();
        Assert.assertTrue("Заголовок главной страницы не отображается", mainPage.isMainPageHeaderDisplayed());
    }
    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
