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

}
