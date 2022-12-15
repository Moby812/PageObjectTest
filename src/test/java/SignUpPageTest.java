import Module.CookiesModule;
import Module.EmailModule;
import Module.PasswordModule;
import Page.SignUpPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

public class SignUpPageTest extends BaseTest{
    private final String url = "https://ru.stackoverflow.com/users/signup";
    private SignUpPage signUpPage;

    @BeforeEach
    public void init() {
        setUp();
        signUpPage = new SignUpPage();
        Selenide.open(url);
        CookiesModule.clickAcceptCookies();
    }

    @Test
    @DisplayName("Загрузка страницы 'Регистрация'")
    public void openSite() {
        Assertions.assertNotNull(signUpPage.providerButton().google());
        Assertions.assertNotNull(signUpPage.providerButton().github());
        Assertions.assertNotNull(signUpPage.providerButton().facebook());
        Assertions.assertNotNull(signUpPage.providerButton().vk());
        Assertions.assertNotNull(signUpPage.providerButton().yandex());
        Assertions.assertNotNull(EmailModule.emailField());
        Assertions.assertNotNull(PasswordModule.passField());

        Assertions.assertEquals("Регистрация",signUpPage.getRegText());
    }

    @Test
    @DisplayName("'Регистрация' без заполнения полей")
    public void openSiteEmptyField() {
        signUpPage.clickSubmit();
        Assertions.assertEquals("Поле ввода почты не может быть пустым.",EmailModule.getErrorEmailText());
        Assertions.assertEquals("Поле ввода пароля не может быть пустым.",PasswordModule.getErrorPasswordText());
        Assertions.assertEquals("Необходимо пройти CAPTCHA.",signUpPage.getErrorReCaptchaText());
    }

    @Test
    @DisplayName("'Регистрация' с паролем только из букв")
    public void registerPassABC() {
        signUpPage.register("","m@test.com","qwerty");
        Assertions.assertEquals("цифры",PasswordModule.getWrongPasswordABCText());
    }

    @Test
    @DisplayName("'Регистрация' с паролем только из цифр")
    public void registerPass123() {
        signUpPage.register("","m@test.com","12345678");
        Assertions.assertEquals("буквы",PasswordModule.getWrongPassword123Text());
    }

    @Test
    @DisplayName("Переход на другую форму через кнопку: 'Войдите'")
    public void openSingUp() {
        Assertions.assertEquals("Войти",signUpPage.pressLoginButton().getLoginText());
    }

}
