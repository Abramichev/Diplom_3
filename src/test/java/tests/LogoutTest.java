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


public class LogoutTest extends Config{

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
    @DisplayName("Log out  from profile page")
    @Description("User can log out from the profile page")
    public void logoutThroughProfileTest() {
        loginPage = profilePage.logoutButtonClick();
        Assert.assertTrue("Кнопка 'Войти' не отображается", loginPage.isLoginButtonDisplayed());
    }
    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
