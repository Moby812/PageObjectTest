package Page;

import Module.EmailModule;
import Module.PasswordModule;
import Module.ProviderButtonModule;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement buttonSubmit = $x("//button[@id='submit-button']");
    private final SelenideElement loginMessage = $x("//*[text()='Войти']");
    private final SelenideElement reg = $x("//a[contains(text(),'Зарегистрируйтесь')]");
    private final SelenideElement forgotPass = $x("//a[@href='/users/account-recovery']");

    public ProviderButtonModule providerButton(){
        return new ProviderButtonModule();
    }

    public void clickSubmit(){
        buttonSubmit.click();
    }

    public SignUpPage clickReg(){
        reg.click();
        return new SignUpPage();
    }

    /**
     * Метод заполняет email и password, возвращает экземпляр LoginPage
     */
    public LoginPage wrongLogin(String email, String password){
        EmailModule.sendEmail(email);
        PasswordModule.sendPass(password);
        this.clickSubmit();
        return this;
    }

    /**
     * Метод заполняет email и password, возвращает экземпляр MainPage
     */
    public MainPage login(String email, String password){
        EmailModule.sendEmail(email);
        PasswordModule.sendPass(password);
        this.clickSubmit();
        return new MainPage();
    }

    /**
     * Получает текст ссылки "Войти"
     */
    public String getLoginText(){
        return loginMessage.getText();
    }

    /**
     * Получает текст ссылки "Забыли пароль?"
     */
    public String getForgotPasswordText(){
        return forgotPass.getText();
    }

}