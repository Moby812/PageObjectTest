package Selenide;

import Selenide.Module.CookiesModule;
import Selenide.Module.EmailModule;
import Selenide.Module.PasswordModule;
import Selenide.Page.LoginPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;


public class LoginPageTest extends BaseTest{
    private final String url = "https://ru.stackoverflow.com/users/login";
    private LoginPage loginPage;

    @BeforeEach
    public void init() {
        setUp();
        loginPage = new LoginPage();
        Selenide.open(url);
        CookiesModule.clickAcceptCookies();
    }

    @Test
    @DisplayName("Загрузка страницы 'Войти'")
    public void openSite() {
        Assertions.assertNotNull(loginPage.providerButton().google());
        Assertions.assertNotNull(loginPage.providerButton().github());
        Assertions.assertNotNull(loginPage.providerButton().facebook());
        Assertions.assertNotNull(loginPage.providerButton().vk());
        Assertions.assertNotNull(loginPage.providerButton().yandex());
        Assertions.assertNotNull(EmailModule.emailField());
        Assertions.assertNotNull(PasswordModule.passField());
        Assertions.assertEquals("Забыли пароль?",loginPage.getForgotPasswordText());
        Assertions.assertEquals("Войти",loginPage.getLoginText());
    }

    @Test
    @DisplayName("'Войти' без заполнения полей")
    public void openSiteEmptyField() {
        loginPage.clickSubmit();
        Assertions.assertEquals("Поле ввода почты не может быть пустым.",EmailModule.getErrorEmailText());
        Assertions.assertEquals("Поле ввода пароля не может быть пустым.",PasswordModule.getErrorPasswordText());
    }

    @Test
    @DisplayName("'Войти' при неправильном формате почты")
    public void openSiteWrongField() {
        loginPage.wrongLogin("88005553535","2931");
        Assertions.assertEquals("Указанный адрес не является действительным адресом электронной почты.",EmailModule.getErrorEmailPasswordText());
    }

    @Test
    @DisplayName("Переход на другую форму через кнопку: 'Зарегистрируйтесь'")
    public void openSingUp() {
        Assertions.assertEquals("Регистрация",loginPage.clickReg().getRegText());
    }

}
