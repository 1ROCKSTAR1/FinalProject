package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AddTaskPage {

    private final SelenideElement titleField = $("input[placeholder='Добавить название']"),
    createButton = $("button.btn.btn-primary.btn-footer");

    @Step("Filling the title of the task")
    public AddTaskPage fillTitleField(String name) {
        titleField.sendKeys(name);
        return this;
    }

    @Step("Click on submit | create a task")
    public MainPage clickOnCreateButton() {
        createButton.click();
        return new MainPage();
    }
}
