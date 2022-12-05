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
}
