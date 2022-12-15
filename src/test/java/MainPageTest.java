import Page.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        Options.propertyDriver();
        driver = Options.createChromeDriver();
        driver.get("https://ru.stackoverflow.com");
        mainPage = new MainPage(driver);
        mainPage.cookies().clickAcceptCookies();
    }

    @Test
    @DisplayName("Загрузка главной страницы")
    public void openSite() {
        Assertions.assertNotNull(mainPage.searchLogo());
        Assertions.assertNotNull(mainPage.searchNavigationMenu());
    }

    @Test
    @DisplayName("Переход на форму входа, кнопкой 'войти'")
    public void singIn(){
        Assertions.assertEquals("Войти",mainPage.clickLogin().getLoginText());
    }

    @Test
    @DisplayName("Переход на форму регистрации, кнопкой 'Регистрация'")
    public void singUp(){
        Assertions.assertEquals("Регистрация",mainPage.clickSignUp().getRegText());
    }

    @Test
    @DisplayName("Переход на форму регистрации, кнопкой 'Присоединиться к сообществу'")
    public void singUpJoin(){
        Assertions.assertEquals("Регистрация",mainPage.clickJoin().getRegText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
