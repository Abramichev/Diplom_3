import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yandex.stellarburgers.api.BaseClient;
import yandex.stellarburgers.model.Client;
import yandex.stellarburgers.pageobjects.AuthPage;
import yandex.stellarburgers.pageobjects.MainPage;
import yandex.stellarburgers.pageobjects.RegistrationPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.page;
import static org.apache.commons.io.IOUtils.close;


public class AuthTests extends BaseClient {
    private RegistrationPage registrationPage;
    private AuthPage authPage;
    private MainPage mainPage;
    private Client registrationCorrectData;

    @Before
    public void createData(){
        registrationPage = page(RegistrationPage.class);
        authPage = page(AuthPage.class);
        mainPage = page(MainPage.class);
        registrationCorrectData = new Client(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru", RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphanumeric(10));
        BaseClient.createClient(registrationCorrectData);
    }

    @After
    public void deleteClient() throws IOException {
        BaseClient.deleteClient(registrationCorrectData);
        close();
    }

    @Test
    @DisplayName("Auth user from registration page")
    @Description("Should auth user from registration page")
    public void shouldAuthExistUserFromRegistrationPage(){
        registrationPage.openPage(registrationURL);
        registrationPage.clickSignUpButton();
        authPage.setEmailInputAlreadyRegisteredUser(registrationCorrectData.getEmail());
        authPage.setPasswordInputAlreadyRegisteredUser(registrationCorrectData.getPassword());
        authPage.clickSignInButton();
        authPage.checkAuth();
    }

    @Test
    @DisplayName("Auth user from main page")
    @Description("Should auth user from main page")
    public void shouldAuthExistUserFromMainPage(){
        mainPage.openPage(BaseURL);
        mainPage.clickLoginButton();
        authPage.setEmailInputAlreadyRegisteredUser(registrationCorrectData.getEmail());
        authPage.setPasswordInputAlreadyRegisteredUser(registrationCorrectData.getPassword());
        authPage.clickSignInButton();
        authPage.checkAuth();
    }

    @Test
    @DisplayName("Auth user from personal account")
    @Description("Should auth user from personal account")
    public void shouldAuthExistUserFromPersonalAccount(){
        mainPage.openPage(BaseURL);
        mainPage.clickPersonalAccountButton();
        authPage.setEmailInputAlreadyRegisteredUser(registrationCorrectData.getEmail());
        authPage.setPasswordInputAlreadyRegisteredUser(registrationCorrectData.getPassword());
        authPage.clickSignInButton();
        authPage.checkAuth();
    }

    @Test
    @DisplayName("Auth user from forgot password page")
    @Description("Should auth user from forgot password page")
    public void shouldAuthExistUserFromForgotPasswordPage(){
        authPage.openPage(loginAPI);
        authPage.clickRetrievePasswordButton();
        authPage.clickSignInButton();
        authPage.setEmailInputAlreadyRegisteredUser(registrationCorrectData.getEmail());
        authPage.setPasswordInputAlreadyRegisteredUser(registrationCorrectData.getPassword());
        authPage.clickSignInButton();
        authPage.checkAuth();
    }
}
