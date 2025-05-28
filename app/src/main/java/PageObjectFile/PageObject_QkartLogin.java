package PageObjectFile;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject_QkartLogin {

    private WebDriver driver;

    //Page Elements using PageFactory
    @FindBy(xpath = "//button[text()='Login']")
    private WebElement Login;

    @FindBy(id = "username")
    private WebElement Login_UserName;

    @FindBy(id = "password")
    private WebElement Login_Password;

    @FindBy(xpath = "//button[text()='Login to QKart']")
    private WebElement Login_Button;

    @FindBy(xpath = "//button[text()='Logout']")
    private WebElement Logout;

    // Constructor
    public PageObject_QkartLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Java_Selenium Methods/Logic Actions
    public void Login() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String loginURL = null;

        if (Login.isDisplayed()) {
            System.out.println("Login button is disaplay : PASS");
            Login.click();
            loginURL = driver.getCurrentUrl();
        } else {
            System.out.println("Login button is not disaplay");
        }

        if (loginURL.contains("login")) {
            System.out.println("System is navigate to login page successfully : PASS");
            Login_UserName.sendKeys("AkshayZankat@gmail.com");
            Login_Password.sendKeys("Akshay@123");
            Login_Button.click();
            System.out.println("Username login successfully : PASS");
            
            wait.until(ExpectedConditions.visibilityOf(Logout)).click();
            Thread.sleep(2000);
        } else {
            System.out.println("System is not navigate to login page");
        }
    }

}
