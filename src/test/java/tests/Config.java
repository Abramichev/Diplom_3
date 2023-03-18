package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;

public class Config {
    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        // для запуска тестов в Яндекс-браузере:
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Configuration.browserSize = "1920x1080";
    }
}
