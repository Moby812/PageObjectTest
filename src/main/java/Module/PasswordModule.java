package Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordModule {

    private final WebDriver driver;

    public PasswordModule(WebDriver driver){
        this.driver = driver;
    }

    private final By password = By.xpath("//input[@id='password']");
    //    private final By nullPassword = By.xpath("//input[@id='password']/../preceding-sibling::p[contains(@class,'error-message')]");
    private final By nullPassword = By.xpath("//p[contains(@class,'error-message') and contains(text(),'пароля ')]");
    private final By wrongPassABC = By.xpath("//li[@id='num']");
    private final By wrongPass123 = By.xpath("//li[@id='ch']");

    public PasswordModule passField(){
        driver.findElement(password);
        return this;
    }

    public void sendPass(String text){
        driver.findElement(password).sendKeys(text);
    }

    public String getErrorPasswordText(){
        return driver.findElement(nullPassword).getText();
    }

    public String getWrongPasswordABCText(){
        return driver.findElement(wrongPassABC).getText();
    }

    public String getWrongPassword123Text(){
        return driver.findElement(wrongPass123).getText();
    }
}
