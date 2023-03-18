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


public class GoToProfilePageTest extends Config{

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
    }
    @Test
    @DisplayName("Go to personal profile page")
    @Description("User can go to the profile from the main page")
    public void goToProfilePageTest() {
        profilePage = mainPage.personalAccWithAuthButtonClick();
        Assert.assertEquals("Некорректный email в профиле!", profilePage.getUserEmail(), email);
    }
    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
