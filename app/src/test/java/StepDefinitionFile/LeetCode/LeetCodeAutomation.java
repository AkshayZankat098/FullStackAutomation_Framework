package StepDefinitionFile.LeetCode;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

public class LeetCodeAutomation extends BaseTest {

    @Test
    public void TestCase01() {

//  Description: Verify that the Leetcode homepage URL contains "leetcode"
//  Test Steps:
//        1) Navigate to the Leetcode website ( https://leetcode.com/ ).
//        2) Verify that the URL contains "leetcode"
//  Expected Result: The URL of the Leetcode homepage contains "leetcode"

        System.out.println("Start TestCase01 : START");
        leetCode.TestCase01();
        System.out.println("End TestCase01 : END : PASS");
    }

    @Test
    public void TestCase02() {

//  Description: Retrieve details of the first 5 questions on the problems page..
//  Test Steps:
//       1) Click on the "Questions" link on the Leetcode homepage.
//       2) Verify that you are on the problem set page, by checking the URL contains "problemset".
//       3) Retrieve the details of the first 5 questions and print them.
//       4) Make sure to check that the title of each question is correct and that you are selecting the questions from the first problem, i.e., "Two Sum".
//  Expected Result: The correct details of the problems are obtained and verified.

        System.out.println("Start TestCase02 : START");
        leetCode.TestCase02();
        System.out.println("End TestCase02 : END : PASS");
    }

    @Test
    public void TestCase03() {

//  Description: Open the Two Sum problem and verify the URL.
//  Test Steps:
//       1) Open the first problem i.e, Two Sum.
//       2) Verify that the URL contains "two-sum"
//  Expected Result: The URL of the problem contains "two-sum"

        System.out.println("Start TestCase03 : START");
        leetCode.TestCase03();
        System.out.println("End TestCase03 : END : PASS");
    }

    @Test
    public void TestCase04() {

//  Description: Check the submissions tab and verify if it displays "Register or Sign In"
//  Test Steps:
//       1) Click on the submission tab.
//       2) Verify that it displays "Register or Sign In"
//  Expected Result: The message "Register or Sign In" is displayed when you click on the submissions tab.

        System.out.println("Start TestCase04 : START");
        leetCode.TestCase04();
        System.out.println("End TestCase04 : END : PASS");
    }
}
