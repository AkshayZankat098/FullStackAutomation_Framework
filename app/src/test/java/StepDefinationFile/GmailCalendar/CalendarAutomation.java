package StepDefinationFile.GmailCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import BaseTest.BaseTest;
import org.testng.annotations.Test;

public class CalendarAutomation extends BaseTest {

    @Test
    public void TestCase01 () {

//  TestCase01 : Verify Calendar Home Page
//  Description: Verify the URL of the Google Calendar home page
//  Test Steps :
//         1) Navigate to Google Calendar ( https://calendar.google.com/ ).
//         2) Verify that the current URL contains "calendar."
//  Expected Result : The URL of the Calendar homepage contains "calendar".

        System.out.println("TestCase01 : START");
        initializeBrowserAndPage();
        gmailCalendar.TestCase01();
        System.out.println("TestCase01 : END : PASS");

    }

    @Test
    public  void TestCase02() throws InterruptedException {

//  TestCase02: Verify Calendar Navigation and Add Task
//  Description: Switch to the month view, and add a task for today.
//  Test Steps:
//       1) Switch to the month view.
//       2) Click on the calendar to add a task.
//       3) Navigate to the Tasks tab.
//       4) Select a date and enter task details. Task Details:
//                  Title: Crio INTV Task Automation
//                  Description: Crio INTV Calendar Task Automation
//
//  Expected Result: The Calendar switched to month view and a task was created.

        System.out.println("TestCase02 : START");
        gmailCalendar.TestCase02();
        System.out.println("TestCase02 : END : PASS");
    }

    @Test
    public  void TestCase03 () throws InterruptedException {

//  TestCase03: Verify the Task Updation
//  Description: Select an existing task, update its description, and verify the successful update.
//  Test Steps:
//       Click on an existing task.
//       Open the task details.
//       Update the task description to "Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application"
//       Verify that the updated description is displayed.
//  Expected Result: The task description is successfully updated and displayed.

        System.out.println("TestCase03 : START");
        gmailCalendar.TestCase03();
        System.out.println("TestCase03 : END : PASS");
    }

    @Test
    public  void TestCase04 () throws InterruptedException {

//  TestCase04: Verify the Task deletion
//  Description: Delete an existing task and confirm the deletion.
//  Test Steps:
//        Click on an existing task.
//        Open the task details.
//        Verify the title of the task.
//        Delete the task.
//        Confirm the task deletion, by verifying "Task deleted" is displayed.
//  Expected Result: The task is successfully deleted, and the confirmation message indicates "Task deleted"

        System.out.println("TestCase04 : START");
        gmailCalendar.TestCase04();
        System.out.println("TestCase04 : END : PASS");
    }
}
