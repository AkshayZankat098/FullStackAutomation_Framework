package StepDefinationFile.LeetCode;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseTest.BaseTest;

public class LeetCodeAutomation extends BaseTest {

    public  void testCase01(){
        
        System.out.println("Start Test case : TestCase01");
        driver.get("https://leetcode.com/");
        String getURL = driver.getCurrentUrl();

        if (getURL.contains("leetcode")) { 
            System.out.println("Test case passed");
        } else {
            System.out.println("Test case failed");
        }

        System.out.println("End Test case: TestCase01");
    }

    public void testCase02 () {
        System.out.println("Start Test case : TestCase02");
        driver.get("https://leetcode.com/");

        WebElement ViewQuestions = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        ViewQuestions.click();

        String Problemset = driver.getCurrentUrl();

        if (Problemset.contains("problemset")) {
            System.out.println("Contains problemset");
        } else {
            System.out.println("Not contains problemset");
        }
            
            List<WebElement> questions = driver.findElements(By.xpath("//div[@class='truncate']"));   

            List<String> fiveQuestions = new ArrayList<>();

            for (int i = 1; i < questions.size(); i++) { 

                System.out.println(questions.get(i).getText());
                fiveQuestions.add(questions.get(i).getText());

                if (i==5) {
                    break;
                }
            }

            if (fiveQuestions.get(0).contains("1. Two Sum")) {
                System.out.println("The correct details of the problems are obtained and verified. :: Test PASS");
            } else {
                System.out.println("Not contains Two Sum :: Test FAIL");
            }

            System.out.println("End Test case : TestCase02");
        }

    public void testCase03 () {
        System.out.println("Start Test case : TestCase03");

        driver.get("https://leetcode.com/");

        WebElement ViewQuestions = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        ViewQuestions.click();

        driver.findElement(By.xpath("//a[text()='Two Sum']")).click();

        String two_sumURL = driver.getCurrentUrl();
        if (two_sumURL.contains("two-sum")) {
            System.out.println("The URL of the problem contains \"two-sum\" :: TEST PASS");
        } else {
            System.out.println("The URL of the problem not contains \"two-sum\" :: TEST FAIL");
        }

        System.out.println("End Test case : TestCase03");
    }
    
    public void testCase04 () {
        
        System.out.println("Start Test case : TestCase04");

        driver.get("https://leetcode.com/");

        WebElement ViewQuestions = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        ViewQuestions.click();

        driver.findElement(By.xpath("//a[text()='Two Sum']")).click();

        WebElement Submissions = driver.findElement(By.xpath("//div[contains(@class, 'normal') and contains(text(), 'Submissions')]"));
        Submissions.click();

        WebElement Register = driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
        String RegisterText = Register.getText();

        if (RegisterText.contains("Register or Sign In")) {
            System.out.println("The message \"Register or Sign In\" is displayed when you click on the submissions tab. :: TEST PASS");
        } else {
            System.out.println("TEST FAIL");
        }

        System.out.println("End Test case : TestCase04");
    }
}
