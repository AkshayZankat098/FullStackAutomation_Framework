package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectFile.PageObject_QkartLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static WebDriver driver;
    protected PageObject_QkartLogin loginPage;  // ✅ Accessible to child test classes

    public void initializeBrowserAndPage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //✅ Initialize Page Object
        loginPage = new PageObject_QkartLogin(driver);

    }

}
