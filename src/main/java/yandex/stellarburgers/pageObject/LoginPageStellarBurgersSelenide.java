package yandex.stellarburgers.pageObject;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageStellarBurgersSelenide {

    @FindBy(how= How.XPATH, using = ".//input[@type='text']")
    private SelenideElement emailField;
    @FindBy(how= How.XPATH, using = ".//input[@type='password']")
    private SelenideElement passwordField;
    @FindBy(how= How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;
    @FindBy(how= How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerButton;
    @FindBy(how= How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement resetPasswordButton;

    public void setEmail(String email) {
        emailField.setValue(email);
    }
    public void setPassword(String password) {
        passwordField.setValue(password);
    }
    public MainPageStellarBurgersSelenide loginButtonClick() {
        loginButton.click();
        MainPageStellarBurgersSelenide mainPage = Selenide.page(MainPageStellarBurgersSelenide.class);
        mainPage.waitForLoadMainPage();
        return mainPage;
    }
    public RegisterPageStellarBurgersSelenide registerButtonClick() {
        registerButton.click();
        RegisterPageStellarBurgersSelenide registerPage = Selenide.page(RegisterPageStellarBurgersSelenide.class);
        registerPage.waitForLoadRegisterPage();
        return registerPage;
    }
    public ResetPasswordPageStellarBurgersSelenide resetPasswordButtonClick() {
        resetPasswordButton.click();
        ResetPasswordPageStellarBurgersSelenide resetPasswordPage = Selenide.page(ResetPasswordPageStellarBurgersSelenide.class);
        resetPasswordPage.waitForLoadResetPasswordPage();
        return resetPasswordPage;
    }
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        loginButtonClick();
    }
    public void waitForLoadLoginPage() {
        loginButton.shouldBe(Condition.visible);
    }
    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
}
