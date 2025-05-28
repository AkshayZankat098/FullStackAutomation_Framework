package PageObjectFile;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject_Searchbox {

    private WebDriver driver;

    //Page Elements using PageFactory
    @FindBy(xpath = "(//input[@name='search'])[1]")
    private WebElement search;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-yg30e6']")
    private WebElement Result;

    // Constructor
    public PageObject_Searchbox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Search(String Name1, String Name2) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(search)).click();
        wait.until(ExpectedConditions.visibilityOf(search)).sendKeys(Name1);

        String Search_ResultYonex = wait.until(ExpectedConditions.visibilityOf(Result)).getText();
        if (Search_ResultYonex.contains("YONEX")) {
            System.out.println("yonex text in their Search_Result : PASS");
        } else {
            System.out.println("yonex text in not their in Search_Result : FAIL");
        }

        wait.until(ExpectedConditions.visibilityOf(search)).click();
        wait.until(ExpectedConditions.visibilityOf(search)).clear();
        wait.until(ExpectedConditions.visibilityOf(search)).sendKeys(Name2);

        String Search_ResultGesundheit = driver.findElement(By.xpath("//div[@class='loading MuiBox-root css-0']")).getText();
        if (Search_ResultGesundheit.contains(" No products found ")) {
            System.out.println("No products found : PASS");
        } else {
            System.out.println("No products found validation message not present : FAIL");
        }
    }

}
