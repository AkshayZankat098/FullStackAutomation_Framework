package PageObjectFile;

import java.util.AbstractList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Amazon {

    private WebDriver driver;

    //Page Elements using PageFactory
    @FindBy(id = "twotabsearchtextbox")
    private WebElement search;

    @FindBy(id = "nav-search-submit-button")
    private WebElement Click_search;

    // Constructor
    public PageObject_Amazon(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Java_Selenium Methods/Logic Actions
    public void Search_Case(String ProductName) {
        search.sendKeys(ProductName);
        Click_search.click();
    }

    public void GetTen_Product(String ProductName) {

        List<WebElement> productList = driver.findElements(By.xpath("//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']//h2//span"));

        for (WebElement product : productList) {
            String Product_Name = product.getText();
            System.out.println(Product_Name);
        }

    }

}
