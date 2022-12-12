package Selenid.Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailModule {

    private final WebDriver driver;

    public EmailModule(WebDriver driver){
        this.driver = driver;
    }

    private final By email = By.xpath("//input[@id='email']");
    //    private final By nullEmail = By.xpath("//input[@id='email']/../following-sibling::p[contains(@class,'error-message')]");
    private final By nullEmail = By.xpath("//p[contains(@class,'error-message') and contains(text(),'почты')]");
    private final By errorMessage = By.xpath("//p[@class='flex--item s-input-message js-error-message ']");

    public EmailModule emailField(){
        driver.findElement(email);
        return this;
    }

    public void sendEmail(String text){
        driver.findElement(email).sendKeys(text);
    }

    public String getErrorEmailText(){
        return driver.findElement(nullEmail).getText();
    }

    public String getErrorEmailPasswordText(){
        return driver.findElement(errorMessage).getText();
    }
}
