package Selenide.Module;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class ProviderButtonModule {

    private final SelenideElement google = $x("//button[@data-provider='google']");
    private final SelenideElement github = $x("//button[@data-provider='github']");
    private final SelenideElement facebook = $x("//button[@data-provider='facebook']");
    private final SelenideElement vk = $x("//button[@data-provider='vk']");
    private final SelenideElement yandex = $x("//button[@data-provider='yandex']");


    public SelenideElement google(){
        return google;
    }
    public SelenideElement github(){
        return github;
    }
    public SelenideElement facebook(){
        return facebook;
    }
    public SelenideElement vk(){
        return vk;
    }
    public SelenideElement yandex(){
        return yandex;
    }

}
