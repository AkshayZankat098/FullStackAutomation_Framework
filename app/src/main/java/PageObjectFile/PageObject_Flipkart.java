package PageObjectFile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Flipkart {

    private WebDriver driver;

    //Page Elements using PageFactory
    @FindBy(xpath = "//input[@title='Search for Products, Brands and More']")
    private WebElement search;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement Click_search;

    // Constructor
    public PageObject_Flipkart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Java_Selenium Methods/Logic Actions
    public void Search_Case(String ProductName) {
        search.sendKeys(ProductName);
        Click_search.click();
    }

    public void GetTen_Product() {

        List<WebElement> productList = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
        List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='Nx9bqj']"));

        int count = 10;

        for (int i = 0; i < count; i++) {
            String productName = productList.get(i).getText();
            String PriceText = productPrice.get(i).getText();
            String ActualPrice = PriceText.replaceAll("[^0-9]", "");
            System.out.println(productName + " :: " + ActualPrice);
        }

        System.err.println("Total Products Found: " + productList.size());   
        System.err.println("Total Prices Found: " + productPrice.size());
    }

    //Wrapper method to click element
    public static void clickElement(WebElement element) {
        element.click();
    }

    //Wrapper method to get text
    public static String getText(WebElement element) {
        return element.getText();
    }

}
