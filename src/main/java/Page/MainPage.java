package Page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement logo = $x("//span[@class='-img _glyph']");
    private final SelenideElement search = $x("//input[@placeholder='Поиск...']");
    private final SelenideElement buttonLogin = $x("//a[contains(text(),'Войти') and @role='menuitem']");
    private final SelenideElement buttonSignUp = $x("//a[contains(text(),'Регистрация') and @role='menuitem']");
    private final SelenideElement buttonJoin = $x("//a[@class='s-btn s-btn__primary']");
    private final SelenideElement buttonAsk = $x("//a[@class='ws-nowrap s-btn s-btn__primary']");
    private final SelenideElement navigationLinks = $x("//ol[contains(@class,'nav-links')]");


    /**
     * поиск лого сайта
     */
    public SelenideElement searchLogo(){
        return logo;
    }

    /**
     * поиск навигационного меню
     */
    public SelenideElement searchNavigationMenu(){
        return navigationLinks;
    }

    /**
     * Клик по ссылке "Войти"
     */
    public LoginPage clickLogin(){
        buttonLogin.click();
        return new LoginPage();
    }

    /**
     * Клик по ссылке "Регистрация"
     */
    public SignUpPage clickSignUp(){
        buttonSignUp.click();
        return new SignUpPage();
    }

    /**
     * Клик по ссылке "Присоединиться"
     */
    public SignUpPage clickJoin(){
        buttonJoin.click();
        return new SignUpPage();
    }

    public QuestionsAskPage clickAsk(){
        buttonAsk.click();
        return new QuestionsAskPage();
    }

    public void sendTextSearch(String text){
        search.sendKeys(text, Keys.ENTER);
    }

    public void clickNavigationMenu(String text) {
        String dirMenu = navigationLinks.toString().replace("By.xpath: ","")+"//*[contains(text(),'" + text + "')]";
        $x(dirMenu).click();
    }
}
