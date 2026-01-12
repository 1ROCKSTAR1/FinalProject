package web.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement loginField = $(By.cssSelector("input[type='text']")),
            passwordField = $(By.cssSelector("input[type='password']")),
            submitButton = $(By.cssSelector("button[type='Submit']"));

    @Step("Переход на страницу")
    public LoginPage navigateToTheForm() {
        open("https://habitica.com/login");
        return this;
    }

    @Step("Заполнение логина")
    public LoginPage fillTheLoginField() {
        loginField.sendKeys("sir.nevajn@yandex.ru");
        return this;
    }

    @Step("Заполнение пароля")
    public LoginPage fillThePasswordField() {
        passwordField.sendKeys("driver_7890");
        return this;
    }

    @Step("Submit")
    public MainPage clickOnSubmitButton() {
        submitButton.click();
        return new MainPage();
    }

    @Step("Получение статуса видимости статистики пользователя")
    public boolean checkSubmitClickable() {
        try {
            submitButton.shouldNotBe(clickable, Duration.ofSeconds(5));
            return true;
        } catch (ElementNotFound | ElementNotInteractableException e) {
            return false;
        }
    }
}
