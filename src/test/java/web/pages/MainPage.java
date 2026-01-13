package web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement userStats = $(By.cssSelector("div[class='member-stats']")),
    addTaskButton = $x("//div[contains(text(),'Добавить задачу')]"),
    taskButton = $x("//div[text()=' задачу ']"),
    taskPlaque = $x("//div[@class='task-content']//p[1]");

    private final ElementsCollection listOfTasks = $$x("//div[@class='task-content']//p");

    @Step("Получение статуса видимости статистики пользователя")
    public boolean checkUserStatsShown() {
        try {
            userStats.shouldBe(visible, Duration.ofSeconds(5));
            return true;
        } catch (ElementNotFound | ElementNotInteractableException e) {
            return false;
        }
    }

    @Step("Нажать на кнопку Добавить задачу")
    public MainPage clickOnAddTask() {
        addTaskButton.click();
        return this;
    }

    @Step("Нажать на кнопку Добавить задачу")
    public AddTaskPage clickOnTaskItem() {
        taskButton.click();
        return new AddTaskPage();
    }

    @Step("Получение текста из задачи")
    public String getTaskTitle() {
        return taskPlaque.getText();
    }

    @Step("Проверка списка задач")
    public boolean checkListOfTasks(String name) {
        return listOfTasks
                .asFixedIterable()
                .stream()
                .anyMatch(element -> element.getText().contains(name));
    }
}
