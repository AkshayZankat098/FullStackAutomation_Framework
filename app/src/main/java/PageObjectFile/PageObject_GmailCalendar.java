package PageObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_GmailCalendar {

    private WebDriver driver;

    //Page Elements using PageFactory
    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    // Constructor
    public PageObject_GmailCalendar (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Java_Selenium Methods/Logic Actions
    public void TestCase01 () {

        driver.get("https://calendar.google.com/");
        String CurrentURL = driver.getCurrentUrl();

        if (CurrentURL.contains("calendar")) {
            System.out.println("The URL of the Calendar homepage contains \"calendar\". :: TEST PASS");
        } else {
            System.out.println("The URL of the Calendar homepage not contains \"calendar\". :: TEST FAIL");
        }

    }

    public void TestCase02 () throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement MonthDropdown = driver.findElement(By.xpath("//button[contains(@class, 'AeBiU-LgbsSe') and contains(@jsname, 'jnPWCc')]"));
        js.executeScript("arguments[0].click();", MonthDropdown);

        Thread.sleep(2000);
        WebElement Selectmonth = driver.findElement(By.xpath("//li[@role='menuitem' and @data-viewkey='month']//span[@class='RBHQF-ksKsZd']"));
        js.executeScript("arguments[0].click();", Selectmonth);

        Thread.sleep(2000);
        WebElement MonthText = driver.findElement(By.xpath("//span[@class='AeBiU-vQzf8d' and normalize-space(text())='Month']"));
        String Monthtext = MonthText.getText();

        Thread.sleep(2000);
        if (Monthtext.contains("Month")) {
            System.out.println("The Calendar switched to month view");
        } else {
            System.out.println("The Calendar is not switched to month view");
        }

        Thread.sleep(2000);
        WebElement ClickCreate = driver.findElement(By.xpath("//span[text()='Create']"));
        js.executeScript("arguments[0].click();", ClickCreate);

        Thread.sleep(2000);
        WebElement ClickTask = driver.findElement(By.xpath("//span[text()='Task']"));
        js.executeScript("arguments[0].click();", ClickTask);

        WebElement Addtital = driver.findElement(By.xpath("//input[@aria-label='Add title']"));
        Addtital.sendKeys("Crio INTV Task Automation");

        WebElement AddDescription = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        AddDescription.sendKeys("Crio INTV Calendar Task Automation");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='yDmH0d']/div/div/div[2]/span/div/div[1]/div[2]/div[2]/div[4]/button")).click();
        WebElement messageElement = driver.findElement(By.xpath("//div[@class='VYTiVb']"));

        if (messageElement.isDisplayed()) {
            System.out.println("The Calendar switched to month view and a task was created. :: TEST PASS");
        } else {
            System.out.println("The Calendar is not switched to month view and a task was not created. :: TEST FAIL");
        }

        Thread.sleep(2000);
        WebElement openTask = driver.findElement(By.xpath("//*[@id='YPCqFe']/div/div/div/div[2]/div[2]/div[3]/div/div[3]/div/div/div"));
        js.executeScript("arguments[0].click();", openTask);

        WebElement Description = driver.findElement(By.xpath("//span[text()='Description:']"));
        String DetailDescription = Description.getText();

        if (DetailDescription.contains("Crio INTV Calendar Task Automation")) {
            System.out.println("description is correct");
        } else {
            System.out.println("description is not correct");
        }

        driver.findElement(By.xpath("//*[@id=\"xDetDlgCloseBu\"]")).click();
    }

    public void TestCase03 () throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(8000);
        WebElement openTask = driver.findElement(By.xpath("//*[@id='YPCqFe']/div/div/div/div[2]/div[2]/div[3]/div/div[3]/div/div/div"));
        openTask.click();

        WebElement editButton = driver.findElement(By.xpath("//*[@id='yDmH0d']/div/div/div[2]/span/div/div[1]/div/div/div[2]/div[1]/span/button/div"));
        editButton.click();

        Thread.sleep(3000);
        WebElement ChangeDescription = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        ChangeDescription.clear();
        ChangeDescription.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");

        //Click on save
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id='yDmH0d']/div/div/div[2]/span/div/div[8]/div/button")).click();

        WebElement messageElement = driver.findElement(By.xpath("//div[@class='VYTiVb']"));

        if (messageElement.isDisplayed()) {
            System.out.println("The task description is successfully updated and displayed. :: TEST PASS");
        } else {
            System.out.println("The task description is not successfully updated and displayed. :: TEST FAIL");
        }

        Thread.sleep(4000);
        js.executeScript("arguments[0].click();", openTask);

        WebElement NewDescriptionText = driver.findElement(By.xpath("//*[@id='xDetDlgDesc']"));
        String NewDescription = NewDescriptionText.getText();

        WebElement tital = driver.findElement(By.xpath("//span[@id='rAECCd']"));
        String GetTital = tital.getText();

        if (GetTital.contains("Crio INTV Task Automation")) {
            System.out.println("Tital is correct :: TEST PASS");
        } else {
            System.out.println("Tital is not correct :: TEST FAIL");
        }

        System.out.println(NewDescriptionText.getText());

        if (NewDescription.contains("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application") ) {
            System.out.println("Description is update :: TEST PASS");
        } else {
            System.out.println("Description is not update :: TEST FAIL");
        }
    }

    public void TestCase04() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement openTask = driver.findElement(By.xpath("//*[@id='YPCqFe']/div/div/div/div[2]/div[2]/div[3]/div/div[3]/div/div/div"));
        js.executeScript("arguments[0].click();", openTask);

        WebElement tital = driver.findElement(By.xpath("//span[@id='rAECCd']"));
        String GetTital = tital.getText();

        if (GetTital.contains("Crio INTV Task Automation")) {
            System.out.println("Tital is correct :: TEST PASS");
        } else {
            System.out.println("Tital is not correct :: TEST FAIL");
        }

        WebElement DelteTask = driver.findElement(By.xpath("//button[@jscontroller='PIVayb' and @aria-label='Delete task']"));
        DelteTask.click();

        WebElement DeleteTaskMSG = driver.findElement(By.xpath("//div[@class='VYTiVb']"));
        String DeleteMessage = DeleteTaskMSG.getText();

        System.out.println(DeleteTaskMSG.getText());

        if (DeleteMessage.contains("Task deleted")) {
            System.out.println("Alert Task deleted has been displayed :: TEST PASS");
        } else {
            System.out.println("Alert Task deleted has not been displayed :: TEST FAIL");
        }
    }

}
