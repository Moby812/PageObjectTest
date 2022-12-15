package Module;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EmailModule {

    private final static SelenideElement email = $x("//input[@id='email']");
    private final static SelenideElement nullEmail = $x("//p[contains(@class,'error-message') and contains(text(),'почты')]");
    private final static SelenideElement errorMessage = $x("//p[@class='flex--item s-input-message js-error-message ']");

    public static SelenideElement emailField(){
        return email;
    }

    /**
     * Отправка text в поле email
     */
    public static void sendEmail(String text){
        email.sendKeys(text);
    }

    /**
     * Получить информирование о пустом email
     */
    public static String getErrorEmailText(){
        return nullEmail.getText();
    }

    /**
     * Получить информирование о неправильном формате email
     */
    public static String getErrorEmailPasswordText(){
        return errorMessage.getText();
    }
}
