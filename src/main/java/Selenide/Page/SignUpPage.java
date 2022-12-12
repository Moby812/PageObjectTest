package Selenide.Page;

import Selenide.Module.EmailModule;
import Selenide.Module.PasswordModule;
import Selenide.Module.ProviderButtonModule;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SignUpPage {

    private final SelenideElement login = $x("//input[@id='display-name']");
    private final SelenideElement reCaptcha = $x("//div[@class='recaptcha-checkbox-border']");
    private final SelenideElement errorReCaptcha = $x("//p[@class='s-input-message m0 p0 js-error-message']");
    private final SelenideElement sCheckbox = $x("//input[@id='opt-in']");
    private final SelenideElement submit = $x("//button[@id='submit-button']");
    private final SelenideElement regMessage = $x("//*[text()='Регистрация']");
    private final SelenideElement loginButton = $x("//a[@name='login']");

    public ProviderButtonModule providerButton(){
        return new ProviderButtonModule();
    }

    public void sendLogin(String text){
        login.sendKeys(text);
    }

    public void pressCheckbox(){
        sCheckbox.click();
    }

    public LoginPage pressLoginButton(){
        loginButton.click();
        return new LoginPage();
    }

    public MainPage clickSubmit(){
        submit.click();
        return new MainPage();
    }

    public MainPage register(String login, String email, String password){
        this.sendLogin(login);
        EmailModule.sendEmail(email);
        PasswordModule.sendPass(password);
//        this.pressCaptcha();
        this.pressCheckbox();
        this.clickSubmit();
        return new MainPage();
    }

    public String getRegText(){
        return regMessage.getText();
    }

    public String getErrorReCaptchaText(){
        return errorReCaptcha.getText();
    }

    // TODO: 13.12.2022 глянуть как это реализовать в Selenide
//    public void pressCaptcha(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-')]")));
//        wait.until(ExpectedConditions.elementToBeClickable(reCaptcha)).click();
//    }
}