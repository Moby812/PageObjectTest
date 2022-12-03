import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By logo = By.xpath("//span[@class='-img _glyph']");
    private By search = By.xpath("//input[@placeholder='Поиск...']");
    private By buttonLogin = By.xpath("//a[contains(text(),'Войти') and @role='menuitem']");
    private By buttonSignUp = By.xpath("//a[contains(text(),'Регистрация') and @role='menuitem']");
    private By buttonJoin = By.xpath("//a[@class='s-btn s-btn__primary']");
    private By buttonAsk = By.xpath("//a[@class='ws-nowrap s-btn s-btn__primary']");
    private By navigationLinks = By.xpath("(//ol[contains(@class,'nav-links')])[2]");

    public LoginPage clickLogin(){
        driver.findElement(buttonLogin).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp(){
        driver.findElement(buttonSignUp).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickJoin(){
        driver.findElement(buttonJoin).click();
        return new SignUpPage(driver);
    }

    public QuestionsAskPage clickAsk(){
        driver.findElement(buttonAsk).click();
        return new QuestionsAskPage(driver);
    }

    public void sendTextSearch(String text){
        WebElement send = driver.findElement(search);
        send.sendKeys(text);
        send.sendKeys(Keys.ENTER);
    }

    public void clickNavigation(String text){
        driver.findElement(navigationLinks)
                .findElement(By.xpath("//*[text()='" + text + "']"))
                .click();
    }


}
