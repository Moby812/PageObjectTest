import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
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
        Configuration.headless = true;     //будет ли виден браузер
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @BeforeEach
    public void quit(){
        Selenide.closeWebDriver();
    }

}

