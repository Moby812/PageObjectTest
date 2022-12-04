import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        Options.propertyDriver();
        driver = Options.createChromeDriver();
        driver.get("https://ru.stackoverflow.com/");
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Сайт открылся, элементы доступны")
    public void openSite() {

        Assertions.assertNotNull(mainPage.searchLogo());
        Assertions.assertNotNull(mainPage.searchNavigationMenu());
    }

    @Test
    @DisplayName("Выполнен переход на форму входа")
    public void singIn(){


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
