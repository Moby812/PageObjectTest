package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Module.*;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private final By logo = By.xpath("//span[@class='-img _glyph']");
    private final By search = By.xpath("//input[@placeholder='Поиск...']");
    private final By buttonLogin = By.xpath("//a[contains(text(),'Войти') and @role='menuitem']");
    private final By buttonSignUp = By.xpath("//a[contains(text(),'Регистрация') and @role='menuitem']");
    private final By buttonJoin = By.xpath("//a[@class='s-btn s-btn__primary']");
    private final By buttonAsk = By.xpath("//a[@class='ws-nowrap s-btn s-btn__primary']");
    private final By navigationLinks = By.xpath("//ol[contains(@class,'nav-links')]");

    public CookiesModule cookies(){
        new CookiesModule(driver);
        return new CookiesModule(driver);
    }

    public WebElement searchLogo(){
        return driver.findElement(logo);
    }

    public MainPage searchNavigationMenu(){
        driver.findElement(navigationLinks);
        return this;
    }

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

    public MainPage sendTextSearch(String text){
        WebElement send = driver.findElement(search);
        send.sendKeys(text);
        send.sendKeys(Keys.ENTER);
        return this;
    }

    public MainPage clickNavigationMenu(String text) {
        String dirMenu = navigationLinks.toString().replace("By.xpath: ","")+"//*[contains(text(),'" + text + "')]";
        driver.findElement(By.xpath(dirMenu)).click();
        return this;
    }
}
