package Selenide.Page;

import Selenide.Module.EmailModule;
import Selenide.Module.PasswordModule;
import Selenide.Module.ProviderButtonModule;
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

    public LoginPage wrongLogin(String email, String password){
        EmailModule.sendEmail(email);
        PasswordModule.sendPass(password);
        this.clickSubmit();
        return this;
    }

    public MainPage login(String email, String password){
        EmailModule.sendEmail(email);
        PasswordModule.sendPass(password);
        this.clickSubmit();
        return new MainPage();
    }

    public String getLoginText(){
        return loginMessage.getText();
    }

    public String getForgotPasswordText(){
        return forgotPass.getText();
    }

}