package Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailModule {

    private final WebDriver driver;

    public EmailModule(WebDriver driver){
        this.driver = driver;
    }

    private final By email = By.xpath("//input[@id='email']");

    public EmailModule emailField(){
        driver.findElement(email);
        return this;
    }

    public void sendEmail(String text){
        driver.findElement(email).sendKeys(text);
    }
}
