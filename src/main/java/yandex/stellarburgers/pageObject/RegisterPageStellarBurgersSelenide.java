package yandex.stellarburgers.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPageStellarBurgersSelenide {


    @FindBy(how= How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginButton;
    @FindBy(how= How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;
    @FindBy(how=How.XPATH, using = ".//fieldset[1]//input")
    private SelenideElement nameField;
    @FindBy(how= How.XPATH, using = ".//fieldset[2]//input")
    private SelenideElement emailField;
    @FindBy(how= How.XPATH, using = ".//fieldset[3]//input")
    private SelenideElement passwordField;
    @FindBy(how = How.CLASS_NAME, using = "input__error")
    private SelenideElement wrongPasswordAlert;

    public void setName(String name) {
        nameField.setValue(name);
    }
    public void setEmail(String email) {
        emailField.setValue(email);
    }
    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public LoginPageStellarBurgersSelenide registerButtonClick() {
        registerButton.click();
        LoginPageStellarBurgersSelenide loginPage = page(LoginPageStellarBurgersSelenide.class);
        return loginPage;
    }

    public LoginPageStellarBurgersSelenide loginButtonClick() {
        loginButton.click();
        LoginPageStellarBurgersSelenide loginPage = page(LoginPageStellarBurgersSelenide.class);
        return loginPage;
    }

    public void waitForLoadRegisterPage() {
        registerButton.shouldBe(Condition.visible);
    }

    public boolean isWrongPasswordAlertIsDisabled() {
        return wrongPasswordAlert.isDisplayed();
    }
}
