package Selenid;

import Selenium.Options;
import Selenium.Page.LoginPage;
import Selenium.Page.SignUpPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private SignUpPage signUpPage;

    @BeforeEach
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
        Assertions.assertNotNull(loginPage.providerButton().google());
        Assertions.assertNotNull(loginPage.providerButton().github());
        Assertions.assertNotNull(loginPage.providerButton().facebook());
        Assertions.assertNotNull(loginPage.providerButton().vk());
        Assertions.assertNotNull(loginPage.providerButton().yandex());
        Assertions.assertNotNull(loginPage.email().emailField());
        Assertions.assertNotNull(loginPage.pass().passField());
        Assertions.assertEquals("Забыли пароль?",loginPage.getForgotPasswordText());
        Assertions.assertEquals("Войти",loginPage.getLoginText());
    }

    @Test
    @DisplayName("'Войти' без заполнения полей")
    public void openSiteEmptyField() {
        loginPage.clickSubmit();
        Assertions.assertEquals("Поле ввода почты не может быть пустым.",loginPage.email().getErrorEmailText());
        Assertions.assertEquals("Поле ввода пароля не может быть пустым.",loginPage.pass().getErrorPasswordText());
    }

    @Test
    @DisplayName("'Войти' при неправильном формате почты")
    public void openSiteWrongField() {
        loginPage.wrongLogin("88005553535","2931");
        Assertions.assertEquals("Указанный адрес не является действительным адресом электронной почты.",loginPage.email().getErrorEmailPasswordText());
    }

    @Test
    @DisplayName("Переход на другую форму через кнопку: 'Зарегистрируйтесь'")
    public void openSingUp() {
        loginPage.clickReg();
        Assertions.assertEquals("Регистрация",signUpPage.getRegText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
