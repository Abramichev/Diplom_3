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

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;


public class MainTests extends BaseClient {

    private RegistrationPage registrationPage;
    private AuthPage authPage;
    private MainPage mainPage;
    private Client registrationCorrectData;
    @Step("Initialization of test data")
    @Before
    public void createData(){
        registrationPage = page(RegistrationPage.class);
        authPage = page(AuthPage.class);
        mainPage = page(MainPage.class);
        registrationCorrectData = new Client(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru", RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphanumeric(10));
        BaseClient.createClient(registrationCorrectData);
    }
    @Step("Deleting test data after tests")
    @After
    public void deleteClient(){
        BaseClient.deleteClient(registrationCorrectData);
        close();
    }

    @Test
    @DisplayName("Click personal account button")
    @Description("Should redirect to personal account")
    public void shouldRedirectToPersonalAccount(){
        mainPage.openPage(BaseURL);
        mainPage.clickPersonalAccountButton();
        authPage.setEmailInputAlreadyRegisteredUser(registrationCorrectData.getEmail());
        authPage.setPasswordInputAlreadyRegisteredUser(registrationCorrectData.getPassword());
        authPage.clickSignInButton();
        mainPage.clickPersonalAccountButton();
        mainPage.checkPersonalAccount();
    }


    @Test
    @DisplayName("Constructor from personal account")
    @Description("Should be able to click Constructor-button from personal account")
    public void shouldClickToConstructorFromPersonalAccount(){
        mainPage.openPage(BaseURL);
        mainPage.clickPersonalAccountButton();
        authPage.setEmailInputAlreadyRegisteredUser(registrationCorrectData.getEmail());
        authPage.setPasswordInputAlreadyRegisteredUser(registrationCorrectData.getPassword());
        authPage.clickSignInButton();
        mainPage.clickPersonalAccountButton();
        mainPage.clickConstructorButton();
        mainPage.checkMainPage();
    }

    @Test
    @DisplayName("Logo from personal account")
    @Description("Should be able to click Logo-button from personal account")
    public void shouldClickToLogoFromPersonalAccount(){
        mainPage.openPage(BaseURL);
        mainPage.clickPersonalAccountButton();
        authPage.setEmailInputAlreadyRegisteredUser(registrationCorrectData.getEmail());
        authPage.setPasswordInputAlreadyRegisteredUser(registrationCorrectData.getPassword());
        authPage.clickSignInButton();
        mainPage.clickPersonalAccountButton();
        mainPage.clickLogo();
        mainPage.checkMainPage();
    }

    @Test
    @DisplayName("Check logout button")
    @Description("Should be able to logout from personal account")
    public void shouldLogOutFromAccount(){
        mainPage.openPage(BaseURL);
        mainPage.clickPersonalAccountButton();
        authPage.setEmailInputAlreadyRegisteredUser(registrationCorrectData.getEmail());
        authPage.setPasswordInputAlreadyRegisteredUser(registrationCorrectData.getPassword());
        authPage.clickSignInButton();
        mainPage.clickPersonalAccountButton();
        mainPage.clickLogoutButton();
        mainPage.checkLogout();
    }
    @Test
    @DisplayName("Check Bun button")
    @Description("Should scroll to bun-menu")
    public void shouldBeBunMenu(){
        mainPage.openPage(BaseURL);
        mainPage.clickSauceButton();
        mainPage.clickBunButton();
        mainPage.checkBun();
    }
    @Test
    @DisplayName("Check Sauce button")
    @Description("Should scroll to Sauce-menu")
    public void shouldBeSauceMenu(){
        mainPage.openPage(BaseURL);
        mainPage.clickSauceButton();
        mainPage.checkSauce();
    }

    @Test
    @DisplayName("Check Filling button")
    @Description("Should scroll to Filling-menu")
    public void shouldBeFillingMenu(){
        mainPage.openPage(BaseURL);
        mainPage.clickFillingButton();
        mainPage.checkFilling();
    }
}
