package Selenid;

import Selenium.Options;
import Selenium.Page.LoginPage;
import Selenium.Page.SignUpPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;
    private LoginPage loginPage;

    @BeforeEach
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
        Assertions.assertNotNull(signUpPage.providerButton().google());
        Assertions.assertNotNull(signUpPage.providerButton().github());
        Assertions.assertNotNull(signUpPage.providerButton().facebook());
        Assertions.assertNotNull(signUpPage.providerButton().vk());
        Assertions.assertNotNull(signUpPage.providerButton().yandex());
        Assertions.assertNotNull(signUpPage.email().emailField());
        Assertions.assertNotNull(signUpPage.pass().passField());

        Assertions.assertEquals("Регистрация",signUpPage.getRegText());
    }

    @Test
    @DisplayName("'Регистрация' без заполнения полей")
    public void openSiteEmptyField() {
        signUpPage.clickSubmit();
        Assertions.assertEquals("Поле ввода почты не может быть пустым.",signUpPage.email().getErrorEmailText());
        Assertions.assertEquals("Поле ввода пароля не может быть пустым.",signUpPage.pass().getErrorPasswordText());
        Assertions.assertEquals("Необходимо пройти CAPTCHA.",signUpPage.getErrorReCaptchaText());
    }

    @Test
    @DisplayName("'Регистрация' с паролем только из букв")
    public void registerPassABC() {
        signUpPage.register("","m@test.com","qwerty");
        Assertions.assertEquals("цифры",signUpPage.pass().getWrongPasswordABCText());
    }

    @Test
    @DisplayName("'Регистрация' с паролем только из цифр")
    public void registerPass123() {
        signUpPage.register("","m@test.com","12345678");
        Assertions.assertEquals("буквы",signUpPage.pass().getWrongPassword123Text());
    }

    @Test
    @DisplayName("Переход на другую форму через кнопку: 'Войдите'")
    public void openSingUp() {
        signUpPage.pressLoginButton();
        Assertions.assertEquals("Войти",loginPage.getLoginText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
