import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yandex.stellarburgers.api.BaseClient;
import yandex.stellarburgers.model.Client;
import yandex.stellarburgers.pageobjects.RegistrationPage;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.close;

public class RegistrationTest extends BaseClient {
    private RegistrationPage registrationPage;
    private Client registrationCorrectData;
    private Client registrationInCorrectData;

    @Before
    public void createData(){
        registrationPage = page(RegistrationPage.class);
        registrationCorrectData = new Client(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru", RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphanumeric(10));
        registrationInCorrectData = new Client(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru", RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomAlphanumeric(5));
    }

    @After
    public void deleteClient(){
        BaseClient.deleteClient(registrationCorrectData);
        close();
    }
    @Test
    @DisplayName("Registration new user with correct password")
    @Description("Should create new user")
    public void shouldCreateNewUserWithCorrectPassword() {
        registrationPage.openPage(registrationURL);
        registrationPage.setNameInput(registrationCorrectData.getName());
        registrationPage.setEmailInput(registrationCorrectData.getEmail());
        registrationPage.setPasswordInput(registrationCorrectData.getPassword());
        registrationPage.clickRegisterButton();
        registrationPage.checkRegistration();
    }

    @Test
    @DisplayName("Registration new user with incorrect password (less 6 symbols)")
    @Description("Should be error with short password")
    public void shouldBeErrorWithBadPassword() {
        registrationPage.openPage(registrationURL);
        registrationPage.setNameInput(registrationInCorrectData.getName());
        registrationPage.setEmailInput(registrationInCorrectData.getEmail());
        registrationPage.setPasswordInput(registrationInCorrectData.getPassword());
        registrationPage.clickRegisterButton();
        registrationPage.checkPassword();
    }
}
