package Selenid.Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiesModule {
    private final WebDriver driver;

    public CookiesModule(WebDriver driver){
        this.driver = driver;
    }

    private final By logoCookies = By.xpath("//*[name()='svg' and contains(@class,'spotCookieLg')]");
    private final By acceptCookies = By.xpath("//button[contains(@class,'js-accept-cookies')]");
    private final By optionsCookies = By.xpath("//button[@class='flex--item s-btn s-btn__filled js-cookie-settings']");

    public void clickAcceptCookies(){
        driver.findElement(acceptCookies).click();
        System.out.println("Кукки были приняты");
    }

    public void clickOptionCookies(){
        driver.findElement(acceptCookies).click();
        System.out.println("Настроить параметры кукки");
    }

    public CookiesModule searchLogo(){
        driver.findElements(logoCookies);
        return this;
    }

}
