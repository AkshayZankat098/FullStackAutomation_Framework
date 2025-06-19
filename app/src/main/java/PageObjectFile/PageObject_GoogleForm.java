package PageObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PageObject_GoogleForm {
    private WebDriver driver;

    //Page Elements using PageFactory
    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    // Constructor
    public PageObject_GoogleForm (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Java_Selenium Methods/Logic Actions
    public void TestCase01 () {

        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        WebElement NameField = driver.findElement(By.xpath("//input[@aria-labelledby='i1 i4']"));
        NameField.sendKeys("Crio Learner");

        //Generate epochTime
        long epochTime = Instant.now().getEpochSecond();
        String message = "I want to be the best QA Engineer! " + epochTime;

        WebElement PracticingAutomation = driver.findElement(By.xpath("//textarea[@aria-label='Your answer']"));
        PracticingAutomation.sendKeys(message);

        WebElement AutomationExperience = driver.findElement(By.xpath("//div[@id='i19' and @class='Od2TWd hYsg7c']"));
        AutomationExperience.click();

        //Select Java, Selenium and TestNG from the next check-box
        driver.findElement(By.xpath("//span[text()='Java']")).click();
        driver.findElement(By.xpath("//span[text()='Selenium']")).click();
        driver.findElement(By.xpath("//span[text()='TestNG']")).click();

        WebElement AddressedDropdown = driver.findElement(By.xpath("//span[text()='Choose']"));
        AddressedDropdown.click();

        WebElement ChooseMR = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[3]/span"));
        ChooseMR.click();

        LocalDate GetDate7DaysAgo = LocalDate.now().minusDays(7);
        DateTimeFormatter FormateDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = GetDate7DaysAgo.format(FormateDate);

        WebElement dateField = driver.findElement(By.xpath("//input[@type='date']"));
        dateField.sendKeys(formattedDate);

        WebElement TimeRightNowHOUR = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        WebElement TimeRightNowMIN = driver.findElement(By.xpath("//input[@aria-label='Minute']"));

        TimeRightNowHOUR.click();
        TimeRightNowHOUR.sendKeys("07");

        TimeRightNowMIN.click();
        TimeRightNowMIN.sendKeys("30");

        WebElement SAVE_Button = driver.findElement(By.xpath("//span[text()='Submit']"));
        SAVE_Button.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        System.out.println(successMessage.getText());

    }
}
