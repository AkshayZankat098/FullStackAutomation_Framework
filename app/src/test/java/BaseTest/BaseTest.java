package BaseTest;

import PageObjectFile.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import java.time.Duration;

public class BaseTest {

    // ✅ Accessible to child test classes
    public static WebDriver driver;
    protected PageObject_Qkart Qkart;
    protected PageObject_Flipkart flipkart;
    protected PageObject_GmailCalendar gmailCalendar;
    protected PageObject_GoogleForm googleForm;
    protected PageObject_LeetCode leetCode;
    protected PageObject_YouTube youTube;
    protected Practice practice;

    public BaseTest() {

        String browser = "chrome";
        String URL = "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform";

        String browserLower = browser.toLowerCase();
        String URL_Lower = URL.toLowerCase();

        if (browserLower.equals("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserLower.equals("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(URL);

        //✅ Initialize Page Object
        Qkart = new PageObject_Qkart(driver);
        flipkart = new PageObject_Flipkart(driver);
        gmailCalendar = new PageObject_GmailCalendar(driver);
        googleForm = new PageObject_GoogleForm(driver);
        leetCode = new PageObject_LeetCode(driver);
        youTube = new PageObject_YouTube(driver);
        practice = new Practice(driver);
    }

//    @AfterSuite
//    public void CloseBrowser() {
//        driver.quit();
//    }
}
