import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By google = By.xpath("//button[@data-provider='google']");
    private By github = By.xpath("//button[@data-provider='github']");
    private By facebook = By.xpath("//button[@data-provider='facebook']");
    private By vk = By.xpath("//button[@data-provider='vk']");
    private By yandex = By.xpath("//button[@data-provider='yandex']");

    private By email = By.xpath("//input[@id='email']");
    private By password = By.xpath("//input[@id='password']");
    private By buttonSubmit = By.xpath("//button[@id='submit-button']");
    private By errorMessage = By.xpath("//p[@class='flex--item s-input-message js-error-message ']");
    private By nullEmail = By.xpath("//input[@id='email']/../following-sibling::p[contains(@class,'error-message')]");
    private By nullPassword = By.xpath("//input[@id='password']/../preceding-sibling::p[contains(@class,'error-message')]");
    private By loginMessage = By.xpath("//*[text()='Войти']");
    private By reg = By.xpath("//a[contains(text(),'Зарегистрируйтесь')]");
    private By forgotPass = By.xpath("//a[@href='/users/account-recovery']");
    private By acceptCookies = By.xpath("//button[contains(@class,'js-accept-cookies')]");


    public LoginPage clickAcceptCookies(){
        driver.findElement(acceptCookies).click();
        return this;
    }

    public LoginPage sendEmail(String text){
        driver.findElement(email).sendKeys(text);
        return this;
    }

    public LoginPage sendPassword(String text){
        driver.findElement(password).sendKeys(text);
        return this;
    }

    public MainPage clickSubmit(){
        driver.findElement(buttonSubmit).click();
        return new MainPage(driver);
    }

    public SignUpPage clickReg(){
        driver.findElement(reg).click();
        return new SignUpPage(driver);
    }

    public LoginPage wrongLogin(String email, String password){
        this.sendEmail(email);
        this.sendPassword(password);
        this.clickSubmit();
        return new LoginPage(driver);
    }

    public MainPage login(String email, String password){
        this.sendEmail(email);
        this.sendPassword(password);
        this.clickSubmit();
        return new MainPage(driver);
    }

    public String getLoginText(){
        return driver.findElement(loginMessage).getText();
    }

    public String getErrorEmailText(){
        return driver.findElement(nullEmail).getText();
    }

    public String getErrorPasswordText(){
        return driver.findElement(nullPassword).getText();
    }

    public String getErrorLoginPasswordText(){
        return driver.findElement(errorMessage).getText();
    }

}