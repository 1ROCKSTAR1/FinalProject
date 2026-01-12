package web.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import web.base.BaseTest;
import web.pages.LoginPage;

public class Tests extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
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
    @DisplayName("Login without a username")
    public void loginWithoutUsername() {

        boolean actualSubmitButtonCondition = loginPage
                .navigateToTheForm()
                .fillThePasswordField()
                .checkSubmitClickable();

        Assertions.assertTrue(actualSubmitButtonCondition);
    }

    @Test
    @DisplayName("Login without a password")
    public void loginWithoutPassword() {

        boolean actualSubmitButtonCondition = loginPage
                .navigateToTheForm()
                .fillTheLoginField()
                .checkSubmitClickable();

        Assertions.assertTrue(actualSubmitButtonCondition);
    }

    @Test
    @DisplayName("Login without a username and a password")
    public void loginWithoutUsernameAndPassword() {

        boolean actualSubmitButtonCondition = loginPage
                .navigateToTheForm()
                .checkSubmitClickable();

        Assertions.assertTrue(actualSubmitButtonCondition);
    }

    @Test
    @DisplayName("Add a new task test")
    public void addNewTask() {

        String taskName = loginPage
                .navigateToTheForm()
                .fillTheLoginField()
                .fillThePasswordField()
                .clickOnSubmitButton()
                .clickOnAddTask()
                .clickOnTaskItem()
                .fillTitleField()
                .clickOnCreateButton()
                .getTaskTitle();

        Assertions.assertEquals("Test",taskName);
    }

    @Test
    @DisplayName("Add a new task test")
    public void addNewTask2() {

        boolean taskList = loginPage
                .navigateToTheForm()
                .fillTheLoginField()
                .fillThePasswordField()
                .clickOnSubmitButton()
                .clickOnAddTask()
                .clickOnTaskItem()
                .fillTitleField()
                .clickOnCreateButton()
                .checkListOfTasks();

        Assertions.assertTrue(taskList);
    }
}
