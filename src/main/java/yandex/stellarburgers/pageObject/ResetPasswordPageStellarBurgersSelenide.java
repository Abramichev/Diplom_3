package yandex.stellarburgers.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ResetPasswordPageStellarBurgersSelenide {

    @FindBy(how= How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginButton;
    @FindBy(how= How.XPATH, using = ".//button[text()='Восстановить']")
    private SelenideElement resetPasswordButton;
    public LoginPageStellarBurgersSelenide loginButtonClick() {
        loginButton.click();
        LoginPageStellarBurgersSelenide loginPage = page(LoginPageStellarBurgersSelenide.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    public void waitForLoadResetPasswordPage() {
        resetPasswordButton.shouldBe(Condition.visible);
    }

}
