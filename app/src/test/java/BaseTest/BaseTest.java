package BaseTest;

import PageObjectFile.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    // ✅ Accessible to child test classes
    public static WebDriver driver;
    protected Qkart Qkart;
    protected Flipkart flipkart;
    protected GmailCalendar gmailCalendar;
    protected GoogleForm googleForm;
    protected LeetCode leetCode;
    protected YouTube youTube;
    protected Practice practice;

    public BaseTest() {

        String browser = "chrome";
        String URL = "https://www.flipkart.com/";

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
        Qkart = new Qkart(driver);
        flipkart = new Flipkart(driver);
        gmailCalendar = new GmailCalendar(driver);
        googleForm = new GoogleForm(driver);
        leetCode = new LeetCode(driver);
        youTube = new YouTube(driver);
        practice = new Practice(driver);
    }
    @AfterSuite(alwaysRun = true)
    public void CloseBrowser() {
        driver.quit();
    }
}
