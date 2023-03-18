package yandex.stellarburgers.pageObject;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPageStellarBurgersSelenide {


    @FindBy(how= How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAccButton;

    @FindBy(how= How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement mainPageHeader;

    @FindBy(how= How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginToAccButton;


    @FindBy(how= How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsSection;

    @FindBy(how= How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesSection;

    @FindBy(how= How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsSection;

    @FindBy(how = How.XPATH, using = ".//p[text()='Флюоресцентная булка R2-D3']")
    private SelenideElement R2D3Bun;

    @FindBy(how = How.XPATH, using = ".//p[text()='Соус традиционный галактический']")
    private SelenideElement traditionalGalacticSauce;

    @FindBy(how = How.XPATH, using = ".//p[text()='Сыр с астероидной плесенью']")
    private SelenideElement cheeseWithAsteroidMold;

    public void bunsSectionClick() {
        bunsSection.click();
    }

    public void saucesSectionClick() {
        saucesSection.click();
    }

    public void fillingsSectionClick() {
        fillingsSection.click();
    }

    public void waitForLoadMainPage() {
        mainPageHeader.shouldBe(Condition.visible);
    }

    public LoginPageStellarBurgersSelenide personalAccWithoutAuthButtonClick() {
        personalAccButton.click();
        LoginPageStellarBurgersSelenide loginPage = page(LoginPageStellarBurgersSelenide.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    public PersonalProfilePageStellarBurgersSelenide personalAccWithAuthButtonClick() {
        personalAccButton.click();
        PersonalProfilePageStellarBurgersSelenide profilePage = page(PersonalProfilePageStellarBurgersSelenide.class);
        profilePage.waitForLoadProfilePage();
        return profilePage;
    }

    public LoginPageStellarBurgersSelenide loginToAccButtonClick() {
        loginToAccButton.click();
        LoginPageStellarBurgersSelenide loginPage = page(LoginPageStellarBurgersSelenide.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    public boolean isMainPageHeaderDisplayed() {
        return mainPageHeader.isDisplayed();
    }

    public boolean isR2D3BunDisplayed() {
        return R2D3Bun.isDisplayed();
    }

    public boolean isTraditionalGalacticSauceDisplayed() {
        return traditionalGalacticSauce.isDisplayed();
    }

    public boolean isCheeseWithAsteroidMoldDisplayed() {
        return cheeseWithAsteroidMold.isDisplayed();
    }

}
