package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By login = By.xpath("//input[@id='display-name']");
    private final By email = By.xpath("//input[@id='email']");
    private final By password = By.xpath("//input[@id='password']");
    private final By reCaptcha = By.xpath("//div[@class='recaptcha-checkbox-border']");
    private final By errorReCaptcha = By.xpath("//p[@class='s-input-message m0 p0 js-error-message']");
    private final By sCheckbox = By.xpath("//input[@id='opt-in']");
    private final By submit = By.xpath("//button[@id='submit-button']");
    private final By regMessage = By.xpath("//*[text()='Регистрация']");

    public SignUpPage sendLogin(String text){
        driver.findElement(login).sendKeys(text);
        return this;
    }

    public SignUpPage sendEmail(String text){
        driver.findElement(email).sendKeys(text);
        return this;
    }

    public SignUpPage sendPassword(String text){
        driver.findElement(password).sendKeys(text);
        return this;
    }

    public SignUpPage pressCaptcha(){
        driver.findElement(reCaptcha).isSelected();
        return this;
    }

    public SignUpPage pressCheckbox(){
        driver.findElement(sCheckbox).isSelected();
        return this;
    }

    public MainPage clickSubmit(){
        driver.findElement(submit).click();
        return new MainPage(driver);
    }

    public MainPage register(String login, String email, String password){
        this.sendLogin(login);
        this.sendEmail(email);
        this.sendPassword(password);
        this.pressCaptcha();
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
}