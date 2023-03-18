package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yandex.stellarburgers.StringGenerator;
import yandex.stellarburgers.pageObject.LoginPageStellarBurgersSelenide;
import yandex.stellarburgers.pageObject.MainPageStellarBurgersSelenide;
import yandex.stellarburgers.pageObject.RegisterPageStellarBurgersSelenide;

import static com.codeborne.selenide.Selenide.open;

public class RegisterTest extends  Config{

    MainPageStellarBurgersSelenide mainPage;
    LoginPageStellarBurgersSelenide loginPage;
    RegisterPageStellarBurgersSelenide registerPage;
    StringGenerator stringGenerator = new StringGenerator();
    String name = "alisa";
    String email = stringGenerator.getRandomString();
    String password = "qweQWE123";
    String wrongPassword  ="qweQW";
    @Before
    public void setUp() {
        mainPage = open("https://stellarburgers.nomoreparties.site",
                MainPageStellarBurgersSelenide.class);
        loginPage = mainPage.loginToAccButtonClick();
        registerPage = loginPage.registerButtonClick();
    }
    @Test
    @DisplayName("Sign up with a valid data")
    @Description("User can sign up, using correct login and password")
    public void registerWithValidData() {
        registerPage.setName(name);
        registerPage.setEmail(email);
        registerPage.setPassword(password);
        LoginPageStellarBurgersSelenide loginPage =  registerPage.registerButtonClick();
        loginPage.waitForLoadLoginPage();
        Assert.assertTrue("Кнопка входа на странице авторизации не отображается!", loginPage.isLoginButtonDisplayed());
    }
    @Test
    @DisplayName("Sign up with a invalid data")
    @Description("User can't sign up, using short password")
    public void registerWithWrongPassword() {
        registerPage.setName(name);
        registerPage.setEmail(email);
        registerPage.setPassword(wrongPassword);
        registerPage.registerButtonClick();
        Assert.assertTrue("Сообщение о некорректном пароле не отображается!", registerPage.isWrongPasswordAlertIsDisabled());
    }
    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
