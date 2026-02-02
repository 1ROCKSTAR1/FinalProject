package web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement userInnerName = $x("//h3[@class='character-name']"),
    addTaskButton = $("By.xpath: //div[contains(text(),'Добавить задачу') or contains(text(),'Add task')]"),
    taskButton = $x("//div[text()='Добавить задачу' or text()='Add Task']"),
    taskPlaque = $x("//div[@class='task-content']//p[1]");

    private final ElementsCollection listOfTasks = $$x("//div[@class='task-content']//p");

    @Step("Getting the user's inner name")
    public String getInnerUserName() {
        return userInnerName.getText();
    }

    @Step("Click on 'Add a task'")
    public MainPage clickOnAddTask() {
        addTaskButton.click();
        return this;
    }

    @Step("Click on 'Add a task'")
    public AddTaskPage clickOnTaskItem() {
        taskButton.click();
        return new AddTaskPage();
    }

    @Step("Getting the text from the task")
    public String getTaskTitle() {
        return taskPlaque.getText();
    }

    @Step("Checking the list of the tasks")
    public boolean checkListOfTasks(String name) {
        return listOfTasks
                .asFixedIterable()
                .stream()
                .anyMatch(element -> element.getText().contains(name));
    }
}
