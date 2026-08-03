package PageObjectFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Abstract_Method {

    private WebDriver driver;

    public Abstract_Method(WebDriver driver) {
        this.driver = driver;
    }

    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Wait for an element to be visible
    public WebElement waitForVisibility(WebElement element, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for an element to be clickable
    public WebElement waitForClickable(WebElement element, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for title to contain text
    public boolean waitForTitleContains(String titlePart, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.titleContains(titlePart));
    }

    // Wait for the alert to be present
    public void waitForAlert(int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.alertIsPresent());
    }


}
