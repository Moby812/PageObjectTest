package Selenid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Options {

    public static void propertyDriver() {
        System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");
    }

    public static WebDriver createChromeDriver(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }

}