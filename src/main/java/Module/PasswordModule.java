package Module;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PasswordModule {

    private static final SelenideElement password = $x("//input[@id='password']");
    //    private static final SelenideElement nullPassword = $x("//input[@id='password']/../preceding-sibling::p[contains(@class,'error-message')]");
    private static final SelenideElement nullPassword = $x("//p[contains(@class,'error-message') and contains(text(),'пароля ')]");
    private static final SelenideElement wrongPassABC = $x("//li[@id='num']");
    private static final SelenideElement wrongPass123 = $x("//li[@id='ch']");

    public static SelenideElement passField(){
        return password;
    }

    /**
     * Отправка text в поле password
     */
    public static void sendPass(String text){
        password.sendKeys(text);
    }

    /**
     * Получить информирование о пустом password
     */
    public static String getErrorPasswordText(){
        return nullPassword.getText();
    }

    /**
     * Получить информирование о необходимости в password цифр
     */
    public static String getWrongPasswordABCText(){
        return wrongPassABC.getText();
    }

    /**
     * Получить информирование о необходимости в password букв
     */
    public static String getWrongPassword123Text(){
        return wrongPass123.getText();
    }
}
