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

    @FindBy(xpath = "//div[text()='Popularity']")
    private WebElement Popularity;

    @FindBy(xpath = "//span[contains(@id,'productRating')]//div[text()<= 4.0]")
    private List<WebElement> ratingElements;

    // Constructor
    public PageObject_Flipkart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Java_Selenium Methods/Logic Actions
    public void TestCase01(String ProductName) {
        search.sendKeys(ProductName);
        Click_search.click();
        String searchText = search.getAttribute("value");
        System.out.println(searchText);

        if (searchText.contains("Washing Machine")) {
            System.out.println("Typed Washing Machine into search box");
        }

        Popularity.click();
        System.out.println("Number of rating elements <= 4.0 : " + ratingElements.size());

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
        System.out.println("TestDone");
    }

    //Wrapper method to get text
    public static String getText(WebElement element) {
        return element.getText();

    }

}
