package web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement userInnerName = $x("//h3[@class='character-name']"),
    addTaskButton = $x("//div[contains(text(),'Добавить задачу') or contains(text(),'Add Task')]"),
    taskButton = $x("//div[contains(text(),'задачу') or contains(text(),'To Do')]"),
    taskPlaque = $x("//div[@class='task-content']//p[1]"),
    inventoryButton = $x("//a[contains(text(),'Инвентарь') or contains(text(),'Inventory')]"),
    shopsButton = $x("//a[contains(text(),'Лавки') or contains(text(),'Shops')]");

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

    @Step("Click on inventory")
    public InventoryPage clickOnInventoryButton() {
        inventoryButton.click();
        return new InventoryPage();
    }

    @Step("Click on shops")
    public ShopsPage clickOnShopsButton() {
        shopsButton.click();
        return new ShopsPage();
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
