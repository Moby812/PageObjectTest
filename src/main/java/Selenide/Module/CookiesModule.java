package Selenide.Module;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

abstract public class CookiesModule {

    private static final SelenideElement logoCookies = $x("//*[name()='svg' and contains(@class,'spotCookieLg')]");
    private static final SelenideElement acceptCookies = $x("//button[contains(@class,'js-accept-cookies')]");
    private static final SelenideElement optionsCookies = $x("//button[@class='flex--item s-btn s-btn__filled js-cookie-settings']");

    /**
     * Принять куки
     */
    public static void clickAcceptCookies(){
        acceptCookies.click();
    }

    public static void clickOptionCookies(){
        acceptCookies.click();
    }

    public static SelenideElement searchLogoCookies(){
        return logoCookies;
    }

}
