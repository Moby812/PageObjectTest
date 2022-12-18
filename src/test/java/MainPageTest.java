import Module.CookiesModule;
import Page.MainPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

@Owner("Paramonov Pavel")
public class MainPageTest extends BaseTest{
    private final String url = "https://ru.stackoverflow.com/";
    private MainPage mainPage;

    @BeforeEach
    public void init(){
        setUp();
        mainPage = new MainPage();
        Selenide.open(url);
        CookiesModule.clickAcceptCookies();
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
}
