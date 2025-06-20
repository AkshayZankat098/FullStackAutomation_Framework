package PageObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PageObject_LeetCode {

    private WebDriver driver;


    //Page Elements using PageFactory
    @FindBy(xpath = "//p[text()='View Questions ']")
    private WebElement ViewQuestions;

    @FindBy(xpath = "//a[text()='Two Sum']")
    private WebElement TwoSum;

    // Constructor
    public PageObject_LeetCode(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Java_Selenium Methods/Logic Actions
    public void TestCase01() {

        driver.get("https://leetcode.com/");
        String getURL = driver.getCurrentUrl();

        if (getURL.contains("leetcode")) {
            System.out.println("Test case passed");
        } else {
            System.out.println("Test case failed");
        }
    }

    public void TestCase02 () {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
    }

    public void TestCase03 (){

        ViewQuestions.click();
        TwoSum.click();
        String two_sumURL = driver.getCurrentUrl();

        if (two_sumURL.contains("two-sum")) {
            System.out.println("The URL of the problem contains \"two-sum\" :: TEST PASS");
        } else {
            System.out.println("The URL of the problem not contains \"two-sum\" :: TEST FAIL");
        }
    }

    public void TestCase04 (){

        ViewQuestions.click();
        TwoSum.click();

        WebElement Submissions = driver.findElement(By.xpath("//div[contains(@class, 'normal') and contains(text(), 'Submissions')]"));
        Submissions.click();

        WebElement Register = driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
        String RegisterText = Register.getText();

        if (RegisterText.contains("Register or Sign In")) {
            System.out.println("The message \"Register or Sign In\" is displayed when you click on the submissions tab. :: TEST PASS");
        } else {
            System.out.println("TEST FAIL");
        }
    }


}
