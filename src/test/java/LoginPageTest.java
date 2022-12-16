import Page.*;
import Page.BaseAssertStep;
import io.qameta.allure.Allure;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Owner("Парамонов Павел")
public class LoginPageTest extends BaseAssertStep {
    private WebDriver driver;
    private LoginPage loginPage;
    private SignUpPage signUpPage;

    @BeforeEach
    @Step("Создание драйвера и открытие начальной страницы")
    public void setUp() {
        Options.propertyDriver();
        driver = Options.createChromeDriver();
        driver.get("https://ru.stackoverflow.com/users/login");
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        loginPage.cookies().clickAcceptCookies();
    }

    @Test
    @DisplayName("Загрузка страницы 'Войти'")
    public void openSite() {
        assertNotNull(loginPage.providerButton().google(),"google");
        assertNotNull(loginPage.providerButton().github(),"github");
        assertNotNull(loginPage.providerButton().facebook(),"facebook");
        assertNotNull(loginPage.providerButton().vk(),"vk");
        assertNotNull(loginPage.providerButton().yandex(),"yandex");
        assertNotNull(loginPage.email().emailField());
        assertNotNull(loginPage.pass().passField());
        assertEquals("Забыли пароль?",loginPage.getForgotPasswordText());
        assertEquals("Войти",loginPage.getLoginText());
    }

    @Test
    @DisplayName("'Войти' без заполнения полей")
    public void openSiteEmptyField() {
        loginPage.clickSubmit();
        assertEquals("Поле ввода почты не может быть пустым.",loginPage.email().getErrorEmailText());
        assertEquals("Поле ввода пароля не может быть пустым.",loginPage.pass().getErrorPasswordText());
    }

    @Test
    @DisplayName("'Войти' при неправильном формате почты")
    public void openSiteWrongField() {
        loginPage.wrongLogin("88005553535","2931");
        assertEquals("Указанный адрес не является действительным адресом электронной почты.",loginPage.email().getErrorEmailPasswordText());
    }

    @Test
    @DisplayName("Переход на другую форму через кнопку: 'Зарегистрируйтесь'")
    public void openSingUp() {
        loginPage.clickReg();
        assertEquals("Регистрация",signUpPage.getRegText());
    }

    @AfterEach
    @Step("Закрытие экземпляра драйвера")
    public void tearDown() {
        Allure.getLifecycle().addAttachment(
                "screenshot", "/image/jpeg","jpeg",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        driver.quit();
    }

}
