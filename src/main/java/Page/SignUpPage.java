package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Module.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By login = By.xpath("//input[@id='display-name']");
    private final By reCaptcha = By.xpath("//div[@class='recaptcha-checkbox-border']");
    private final By errorReCaptcha = By.xpath("//p[@class='s-input-message m0 p0 js-error-message']");
    private final By sCheckbox = By.xpath("//input[@id='opt-in']");
    private final By submit = By.xpath("//button[@id='submit-button']");
    private final By regMessage = By.xpath("//*[text()='Регистрация']");
    private final By loginButton = By.xpath("//a[@name='login']");

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

    public SignUpPage sendLogin(String text){
        driver.findElement(login).sendKeys(text);
        return this;
    }

    public SignUpPage pressCheckbox(){
        driver.findElement(sCheckbox).click();
        return this;
    }

    public SignUpPage pressLoginButton(){
        driver.findElement(loginButton).click();
        return this;
    }

    public MainPage clickSubmit(){
        driver.findElement(submit).click();
        return new MainPage(driver);
    }

    public MainPage register(String login, String email, String password){
        this.sendLogin(login);
        new EmailModule(driver).sendEmail(email);
        new PasswordModule(driver).sendPass(password);
//        this.pressCaptcha();
        this.pressCheckbox();
        this.clickSubmit();
        return new MainPage(driver);
    }

    public String getRegText(){
        return driver.findElement(regMessage).getText();
    }

    public String getErrorReCaptchaText(){
        return driver.findElement(errorReCaptcha).getText();
    }

    public void pressCaptcha(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-')]")));
        wait.until(ExpectedConditions.elementToBeClickable(reCaptcha)).click();
    }
}