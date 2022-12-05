import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By email = By.xpath("//input[@id='email']");
    private final By password = By.xpath("//input[@id='password']");
    private final By buttonSubmit = By.xpath("//button[@id='submit-button']");
    private final By errorMessage = By.xpath("//p[@class='flex--item s-input-message js-error-message ']");
    private final By nullEmail = By.xpath("//input[@id='email']/../following-sibling::p[contains(@class,'error-message')]");
    private final By nullPassword = By.xpath("//input[@id='password']/../preceding-sibling::p[contains(@class,'error-message')]");
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

    public void sendEmail(String text){
        driver.findElement(email).sendKeys(text);
    }

    public void sendPassword(String text){
        driver.findElement(password).sendKeys(text);
    }

    public void clickSubmit(){
        driver.findElement(buttonSubmit).click();
        new MainPage(driver);
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

    public String getForgotPasswordText(){
        return driver.findElement(forgotPass).getText();
    }

}