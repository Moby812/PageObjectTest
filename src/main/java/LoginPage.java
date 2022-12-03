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

    public MainPage login(String email, String password){
        this.sendEmail(email);
        this.sendPassword(password);
        this.clickSubmit();
        return new MainPage(driver);
    }

}
