import Page.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Owner("Парамонов Павел")
public class SignUpPageTest extends BaseAssertStep{
    private WebDriver driver;
    private SignUpPage signUpPage;
    private LoginPage loginPage;

    @BeforeEach
    @Step("Создание драйвера и открытие страницы регистрации")
    public void setUp() {
        Options.propertyDriver();
        driver = Options.createChromeDriver();
        driver.get("https://ru.stackoverflow.com/users/signup");
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
        signUpPage.cookies().clickAcceptCookies();
    }

    @Test
    @DisplayName("Загрузка страницы 'Регистрация'")
    public void openSite() {
        assertNotNull(signUpPage.providerButton().google(),"google");
        assertNotNull(signUpPage.providerButton().github(),"github");
        assertNotNull(signUpPage.providerButton().facebook(),"facebook");
        assertNotNull(signUpPage.providerButton().vk(),"vk");
        assertNotNull(signUpPage.providerButton().yandex(),"yandex");
        assertNotNull(signUpPage.email().emailField());
        assertNotNull(signUpPage.pass().passField());

        assertEquals("Регистрация",signUpPage.getRegText());
    }

    @Test
    @DisplayName("'Регистрация' без заполнения полей")
    public void openSiteEmptyField() {
        signUpPage.clickSubmit();
        assertEquals("Поле ввода почты не может быть пустым.",signUpPage.email().getErrorEmailText());
        assertEquals("Поле ввода пароля не может быть пустым.",signUpPage.pass().getErrorPasswordText());
        assertEquals("Необходимо пройти CAPTCHA.",signUpPage.getErrorReCaptchaText());
    }

    @Test
    @DisplayName("'Регистрация' с паролем только из букв")
    public void registerPassABC() {
        signUpPage.register("","m@test.com","qwerty");
        assertEquals("цифры",signUpPage.pass().getWrongPasswordABCText());
    }

    @Test
    @DisplayName("'Регистрация' с паролем только из цифр")
    public void registerPass123() {
        signUpPage.register("","m@test.com","12345678");
        assertEquals("буквы",signUpPage.pass().getWrongPassword123Text());
    }

    @Test
    @DisplayName("Переход на другую форму через кнопку: 'Войдите'")
    public void openSingUp() {
        signUpPage.pressLoginButton();
        assertEquals("Войти",loginPage.getLoginText());
    }

    @AfterEach
    public void tearDown() {
        Allure.getLifecycle().addAttachment(
                "screenshot", "/image/jpeg","jpeg",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        driver.quit();
    }

}
