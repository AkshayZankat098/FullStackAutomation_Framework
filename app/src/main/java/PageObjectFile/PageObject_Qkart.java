package PageObjectFile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject_Qkart {

    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

    @FindBy(xpath = "//button[text()='Register']")
    private WebElement Register;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement Username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement Password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement ConfirmPassword;

    @FindBy(xpath = "//button[text()='Register Now']")
    private WebElement RegisterNow;

    @FindBy(xpath = "//button[text()='Back to explore']")
    private WebElement BackTo_Explore;

    @FindBy(xpath = "//div[@id='notistack-snackbar']")
    private WebElement already_exists;

    @FindBy(xpath = "(//input[@name='search'])[1]")
    private WebElement search;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-yg30e6']")
    private WebElement Result;

    // Constructor
    public PageObject_Qkart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Java_Selenium Methods/Logic Actions
    public void TestCaseID01 () throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        } else {
            System.out.println("System is not navigate to login page");
        }
    }

    public void TestCaseID02 (String email, String pass, String confirmPass) {

        wait.until(ExpectedConditions.visibilityOf(Register)).click();
        Username.sendKeys(email);
        Password.sendKeys(pass);
        ConfirmPassword.sendKeys(confirmPass);
        RegisterNow.click();

        // Wait for the validation message (already_exists element) visible and get text
        String exists_Validation = wait.until(ExpectedConditions.visibilityOf(already_exists)).getText();

        if (exists_Validation.contains("already exists")) {
            System.out.println("Register user already exists");
        } else {
            System.out.println("Register user does not exist");
        }
    }

    public void TestCaseID03 (String Name1, String Name2) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(search)).click();
        wait.until(ExpectedConditions.visibilityOf(search)).sendKeys(Name1);
        Thread.sleep(3000);

        String Search_ResultYonex = wait.until(ExpectedConditions.visibilityOf(Result)).getText();
        if (Search_ResultYonex.contains("YONEX")) {
            System.out.println("yonex text in their Search_Result : PASS");
        } else {
            System.out.println("yonex text in not their in Search_Result : FAIL");
        }

        wait.until(ExpectedConditions.visibilityOf(search)).click();
        wait.until(ExpectedConditions.visibilityOf(search)).clear();
        wait.until(ExpectedConditions.visibilityOf(search)).sendKeys(Name2);
        Thread.sleep(3000);

        WebElement loadingText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='loading MuiBox-root css-0']//h4")));

        String text = loadingText.getText().trim(); //Remove any extra spaces
        System.out.println("Validation Message: " + text);

        if (text.contains("No products found")) {
            System.out.println("No products found: PASS");
        } else {
            System.out.println("No products found validation message not present: FAIL");
        }
    }

    public void TestCaseID04 (String Name3) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(search)).click();
        wait.until(ExpectedConditions.visibilityOf(search)).clear();
        wait.until(ExpectedConditions.visibilityOf(search)).sendKeys(Name3);

    }

}
