package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yandex.stellarburgers.pageObject.*;

import static com.codeborne.selenide.Selenide.open;


public class LoginTest extends Config{

    MainPageStellarBurgersSelenide mainPage;
    LoginPageStellarBurgersSelenide loginPage;
    PersonalProfilePageStellarBurgersSelenide profilePage;
    RegisterPageStellarBurgersSelenide registerPage;
    ResetPasswordPageStellarBurgersSelenide resetPasswordPage;
    String email = "simpson@yandex.ru";
    String password = "qweQWE123";

    @Before
    public void setUp() {
        mainPage = open("https://stellarburgers.nomoreparties.site/",
                MainPageStellarBurgersSelenide.class);
    }
    @Test
    @DisplayName("Go to authorization through the personal account button")
    @Description("User can pass login process, going to authorization through the button 'Personal Account' on the header")
    public void loginFromHeaderButton() {
        loginPage = mainPage.personalAccWithoutAuthButtonClick();
        loginPage.login(email, password);
        profilePage = mainPage.personalAccWithAuthButtonClick();
        Assert.assertEquals(profilePage.getUserEmail(), email);
    }
    @Test
    @DisplayName("Go to authorization through the 'login to account' button")
    @Description("User can pass login process, going to authorization through the button 'Login to account'")
    public void loginFromLoginToAccButton() {
        loginPage = mainPage.loginToAccButtonClick();
        loginPage.login(email, password);
        Assert.assertTrue(mainPage.isMainPageHeaderDisplayed());
    }

    @Test
    @DisplayName("Go to authorization through the 'enter' link on the sign up page")
    @Description("User can pass login process, going to authorization through the link one the registration page")
    public void loginFromRegisterPageButton() {
        loginPage = mainPage.loginToAccButtonClick();
        registerPage = loginPage.registerButtonClick();
        loginPage = registerPage.loginButtonClick();
        loginPage.login(email, password);
        Assert.assertTrue(mainPage.isMainPageHeaderDisplayed());

    }
    @Test
    @DisplayName("Go to authorization through the enter link on the reset password page")
    @Description("User can pass login process, going to authorization through the link 'enter' on the reset password page")
    public void loginFromResetPasswordPage() {
        loginPage = mainPage.loginToAccButtonClick();
        resetPasswordPage = loginPage.resetPasswordButtonClick();
        loginPage = resetPasswordPage.loginButtonClick();
        loginPage.login(email, password);
        Assert.assertTrue(mainPage.isMainPageHeaderDisplayed());
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
