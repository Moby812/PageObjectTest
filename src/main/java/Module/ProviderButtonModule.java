package Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProviderButtonModule {
    private final WebDriver driver;

    public ProviderButtonModule(WebDriver driver){
        this.driver = driver;
    }

    private final By google = By.xpath("//button[@data-provider='google']");
    private final By github = By.xpath("//button[@data-provider='github']");
    private final By facebook = By.xpath("//button[@data-provider='facebook']");
    private final By vk = By.xpath("//button[@data-provider='vk']");
    private final By yandex = By.xpath("//button[@data-provider='yandex']");


    public ProviderButtonModule google(){
        driver.findElement(google);
        return this;
    }
    public ProviderButtonModule github(){
        driver.findElement(github);
        return this;
    }
    public ProviderButtonModule facebook(){
        driver.findElement(facebook);
        return this;
    }
    public ProviderButtonModule vk(){
        driver.findElement(vk);
        return this;
    }
    public ProviderButtonModule yandex(){
        driver.findElement(yandex);
        return this;
    }

}
