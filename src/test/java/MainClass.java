import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainClass {

    public static void main(String[] args) {
        Options.propertyDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://ru.stackoverflow.com/users/login");


        driver.quit();

    }
}
