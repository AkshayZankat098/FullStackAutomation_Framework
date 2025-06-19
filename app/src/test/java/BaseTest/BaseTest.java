package BaseTest;

import PageObjectFile.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static WebDriver driver;
    protected PageObject_Qkart Qkart;          // ✅ Accessible to child test classes
    protected PageObject_Flipkart flipkart;             // ✅ Accessible to child test classes
    protected PageObject_GmailCalendar gmailCalendar;
    protected PageObject_GoogleForm googleForm;
    protected PageObject_LeetCode leetCode;
    protected PageObject_YouTube youTube;
    protected Practice practice;

    public void initializeBrowserAndPage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //✅ Initialize Page Object
        Qkart = new PageObject_Qkart(driver);
        flipkart = new PageObject_Flipkart(driver);
        gmailCalendar = new PageObject_GmailCalendar(driver);
        googleForm = new PageObject_GoogleForm(driver);
        leetCode = new PageObject_LeetCode(driver);
        youTube = new PageObject_YouTube(driver);
        practice = new Practice(driver);


    }

    @AfterTest
    public void CloseBrowser() {
        driver.quit();
    }
}
