import org.openqa.selenium.WebDriver;

public class MainClass {
    public static void main(String[] args) {
        Options.propertyDriver();
        WebDriver dr = Options.createChromeDriver();

        dr.get("https://ru.stackoverflow.com/");

        MainPage mainPage = new MainPage(dr);

        mainPage.clickAcceptCookies();

        mainPage.clickNavigationMenu("Участники");

    }
}
