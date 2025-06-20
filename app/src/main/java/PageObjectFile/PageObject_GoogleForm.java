package PageObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PageObject_GoogleForm {
    private WebDriver driver;

    //Page Elements using PageFactory
    @FindBy(xpath = "//textarea[@aria-label='Your answer']")
    private WebElement PracticingAutomation;

    @FindBy(xpath = "(//input[@class='whsOnd zHQkBf'])[1]")
    private WebElement NameField;

    @FindBy(xpath = "//div[@id='i19' and @class='Od2TWd hYsg7c']")
    private WebElement AutomationExperience;

    @FindBy(xpath = "//span[text()='Choose']")
    private WebElement AddressedDropdown;

    @FindBy(xpath = "(//div[@jsname='wQNmvb']//span[text()='Mr'])[2]")
    private WebElement ChooseMR;

    @FindBy(xpath = "//input[@type='date']")
    private WebElement dateField;

    @FindBy(xpath = "//input[@aria-label='Hour']")
    private WebElement TimeRightNowHOUR;

    @FindBy(xpath = "//input[@aria-label='Minute']")
    private WebElement TimeRightNowMIN;

    @FindBy(xpath = "//span[text()='Submit']")
    private WebElement SAVE_Button;

    @FindBy(xpath = "//div[@class='vHW8K']")
    private WebElement successMessage;

    // Constructor
    public PageObject_GoogleForm (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Java_Selenium Methods/Logic Actions
    public void TestCase01 () throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(NameField));
        NameField.sendKeys("Akshay Zankat");

        //Generate epochTime
        long epochTime = Instant.now().getEpochSecond();
        String message = "I want to be the best QA Engineer! " + epochTime;

        PracticingAutomation.sendKeys(message);
        AutomationExperience.click();

        //Select Java, Selenium and TestNG from the next check-box
        driver.findElement(By.xpath("//span[text()='Java']")).click();
        driver.findElement(By.xpath("//span[text()='Selenium']")).click();
        driver.findElement(By.xpath("//span[text()='TestNG']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AddressedDropdown));
        AddressedDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(ChooseMR));
        ChooseMR.click();
        Thread.sleep(3000);

        LocalDate GetDate7DaysAgo = LocalDate.now().minusDays(7);
        DateTimeFormatter FormateDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = GetDate7DaysAgo.format(FormateDate);

        dateField.sendKeys(formattedDate);
        TimeRightNowHOUR.click();
        TimeRightNowHOUR.sendKeys("07");

        TimeRightNowMIN.click();
        TimeRightNowMIN.sendKeys("30");

        SAVE_Button.click();
        System.out.println(successMessage.getText());

    }
}
