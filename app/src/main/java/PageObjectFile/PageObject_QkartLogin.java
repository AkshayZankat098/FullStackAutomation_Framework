package PageObjectFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_QkartLogin {

    private WebDriver driver;

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

    // Constructor
    public PageObject_QkartLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Page Java_Selenium Methods/Logic Actions
    public void Registration() {
        Register.click();
        Username.sendKeys("AkshayZankat@gmail.com");
        Password.sendKeys("Akshay@123");
        ConfirmPassword.sendKeys("Akshay@123");
        RegisterNow.click();
    }

}
