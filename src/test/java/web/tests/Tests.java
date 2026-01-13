package web.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import web.base.BaseTest;
import web.pages.LoginPage;

public class Tests extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    @Epic("Web")
    @Feature("Login")
    @DisplayName("Successful Login Test")
    public void successfulLoginTest() {

        boolean actualUserStatsCondition = loginPage
                .navigateToTheForm()
                .fillTheLoginField()
                .fillThePasswordField()
                .clickOnSubmitButton()
                .checkUserStatsShown();

        Assertions.assertTrue(actualUserStatsCondition);
    }

    @Test
    @Epic("Web")
    @Feature("Login")
    @DisplayName("Login without a username")
    public void loginWithoutUsername() {

        boolean actualSubmitButtonCondition = loginPage
                .navigateToTheForm()
                .fillThePasswordField()
                .checkSubmitClickable();

        Assertions.assertTrue(actualSubmitButtonCondition);
    }

    @Test
    @Epic("Web")
    @Feature("Login")
    @DisplayName("Login without a password")
    public void loginWithoutPassword() {

        boolean actualSubmitButtonCondition = loginPage
                .navigateToTheForm()
                .fillTheLoginField()
                .checkSubmitClickable();

        Assertions.assertTrue(actualSubmitButtonCondition);
    }

    @Test
    @Epic("Web")
    @Feature("Login")
    @DisplayName("Login without a username and a password")
    public void loginWithoutUsernameAndPassword() {

        boolean actualSubmitButtonCondition = loginPage
                .navigateToTheForm()
                .checkSubmitClickable();

        Assertions.assertTrue(actualSubmitButtonCondition);
    }

    @Test
    @Epic("Web")
    @Feature("Task")
    @DisplayName("Add a new task test")
    public void addNewTask() {

        String taskName = loginPage
                .navigateToTheForm()
                .fillTheLoginField()
                .fillThePasswordField()
                .clickOnSubmitButton()
                .clickOnAddTask()
                .clickOnTaskItem()
                .fillTitleField("Test_1")
                .clickOnCreateButton()
                .getTaskTitle();

        Assertions.assertEquals("Test_1",taskName);
    }

    @Test
    @Epic("Web")
    @Feature("Task")
    @DisplayName("Add a new task test")
    public void addNewTaskStream() {

        boolean taskList = loginPage
                .navigateToTheForm()
                .fillTheLoginField()
                .fillThePasswordField()
                .clickOnSubmitButton()
                .clickOnAddTask()
                .clickOnTaskItem()
                .fillTitleField("Test_2")
                .clickOnCreateButton()
                .checkListOfTasks("Test_2");

        Assertions.assertTrue(taskList);
    }
}
