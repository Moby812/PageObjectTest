import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainClass {

    public static void main(String[] args) {
        Options.propertyDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://ru.stackoverflow.com/users/login");

        driver.findElement(By.xpath("//button[@id='submit-button']")).click();
        WebElement src = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement text = driver.findElement(By.xpath("//input[@id='email']/../following-sibling::p[contains(@class,'error-message')]"));
        System.out.println(src.getText());
        System.out.println(text.getText());

        driver.quit();

    }
}
