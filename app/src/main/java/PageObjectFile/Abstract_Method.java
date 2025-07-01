package PageObjectFile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Abstract_Method {

    protected static WebDriver driver;

    public static void ManageDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Wait for an element to be visible
    public static WebElement waitForVisibility(WebElement element, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for an element to be clickable
    public static WebElement waitForClickable(WebElement element, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for title to contain text
    public static boolean waitForTitleContains(String titlePart, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.titleContains(titlePart));
    }

    // Wait for the alert to be present
    public static void waitForAlert(int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.alertIsPresent());
    }


}
