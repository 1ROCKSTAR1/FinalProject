package web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AddTaskPage {

    private final SelenideElement titleField = $("input[placeholder='Добавить название']"),
    noteField = $("textarea[placeholder='Добавить заметку']"),
    createButton = $("button.btn.btn-primary.btn-footer");

    public AddTaskPage fillTitleField(String name) {
        titleField.sendKeys(name);
        return this;
    }

    public AddTaskPage fillNoteField(String name) {
        noteField.sendKeys(name);
        return this;
    }

    public MainPage clickOnCreateButton() {
        createButton.click();
        return new MainPage();
    }
}
