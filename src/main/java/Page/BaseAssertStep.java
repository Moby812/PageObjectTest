package Page;

import Module.*;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;

abstract public class BaseAssertStep {

    @Step("Проверка доступности социальной кнопки: {buttonName}")
    public void assertNotNull(ProviderButtonModule providerButton, String buttonName) {
        Assertions.assertNotNull(providerButton);
    }

    @Step("Проверка доступности поля email")
    public void assertNotNull(EmailModule email) {
        Assertions.assertNotNull(email);
    }

    @Step("Проверка доступности поля пароль")
    public void assertNotNull(PasswordModule password) {
        Assertions.assertNotNull(password);
    }

    @Step("Проверка ожидаемого текста: {expected}")
    public void assertEquals(String expected, String actual) {
        Assertions.assertEquals(expected,actual);
    }

}
