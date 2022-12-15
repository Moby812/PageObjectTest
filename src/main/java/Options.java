import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Options {

    public static void propertyDriver() {
//        System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");   //win
        System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver");       //linux
    }

    public static WebDriver createChromeDriver(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--whitelisted-ips");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver.manage().window().maximize();
        return driver;
    }

}