package Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;

abstract public class BaseTest {

    /**
     * Инициализация ChromeDriver
     */
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;     //будет ли виден браузер
    }


    @BeforeEach
    public void quit(){
        Selenide.closeWebDriver();
    }

}

