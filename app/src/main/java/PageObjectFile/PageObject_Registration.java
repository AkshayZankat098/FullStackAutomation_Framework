package PageObjectFile;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject_Registration {

    private WebDriver driver;
    public String email;
    public String pass;
    public String confirmPass;

    // Constructor
    public PageObject_Registration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Elements using PageFactory
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

    public void Registration(String email, String pass, String confirmPass) {

        this.email = email;
        this.pass = pass;
        this.confirmPass = confirmPass;

        Register.click();
        Username.sendKeys(email);
        Password.sendKeys(pass);
        ConfirmPassword.sendKeys(confirmPass);
        RegisterNow.click();
        BackTo_Explore.click();

    }

    public void registerWithOld_User() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

}
