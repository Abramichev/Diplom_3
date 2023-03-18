package yandex.stellarburgers.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PersonalProfilePageStellarBurgersSelenide {

    @FindBy(how= How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgerLogo;
    @FindBy(how= How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;
    @FindBy(how= How.XPATH, using = ".//a[text()='Профиль']")
    private SelenideElement profileSection;
    @FindBy(how= How.XPATH, using = ".//input[@type='text' and @name='name']")
    private SelenideElement emailField;
    @FindBy(how= How.XPATH, using = ".//a//p[text()='Конструктор']")
    private SelenideElement constructorButton;
    public void waitForLoadProfilePage() {
        profileSection.shouldBe(Condition.visible);
    }
    public String getUserEmail() {
        return emailField.getAttribute("value");
    }

    public MainPageStellarBurgersSelenide constructorButtonClick() {
        constructorButton.click();
        MainPageStellarBurgersSelenide mainPage = page(MainPageStellarBurgersSelenide.class);
        return mainPage;
    }

    public MainPageStellarBurgersSelenide logoClick() {
        stellarBurgerLogo.click();
        MainPageStellarBurgersSelenide mainPage = page(MainPageStellarBurgersSelenide.class);
        return mainPage;
    }

    public LoginPageStellarBurgersSelenide logoutButtonClick() {
        logoutButton.click();
        LoginPageStellarBurgersSelenide loginPage = page(LoginPageStellarBurgersSelenide.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }
}
