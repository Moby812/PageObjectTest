package Page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Module.*;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By buttonSubmit = By.xpath("//button[@id='submit-button']");
    private final By loginMessage = By.xpath("//*[text()='Войти']");
    private final By reg = By.xpath("//a[contains(text(),'Зарегистрируйтесь')]");
    private final By forgotPass = By.xpath("//a[@href='/users/account-recovery']");

    public ProviderButtonModule providerButton(){
        new ProviderButtonModule(driver);
        return new ProviderButtonModule(driver);
    }

    public CookiesModule cookies(){
        new CookiesModule(driver);
        return new CookiesModule(driver);
    }

    public EmailModule email(){
        new EmailModule(driver);
        return new EmailModule(driver);
    }

    public PasswordModule pass(){
        new PasswordModule(driver);
        return new PasswordModule(driver);
    }

    @Step
    public void clickSubmit(){
        driver.findElement(buttonSubmit).click();
        new MainPage(driver);
    }

    @Step
    public SignUpPage clickReg(){
        driver.findElement(reg).click();
        return new SignUpPage(driver);
    }

    @Step("Введён неверный email и пароль")
    public LoginPage wrongLogin(String email, String password){
        new EmailModule(driver).sendEmail(email);
        new PasswordModule(driver).sendPass(password);
        this.clickSubmit();
        return new LoginPage(driver);
    }

    @Step("Вход на сайт")
    public MainPage login(String email, String password){
        new EmailModule(driver).sendEmail(email);
        new PasswordModule(driver).sendPass(password);
        this.clickSubmit();
        return new MainPage(driver);
    }

    public String getLoginText(){
        return driver.findElement(loginMessage).getText();
    }

    public String getForgotPasswordText(){
        return driver.findElement(forgotPass).getText();
    }

}