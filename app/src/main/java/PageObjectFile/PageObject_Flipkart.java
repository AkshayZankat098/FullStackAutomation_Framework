package PageObjectFile;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.AssertJUnit.assertTrue;

public class PageObject_Flipkart extends Abstract_Method {

    private WebDriver driver;

    //Page Elements using PageFactory
    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement Click_search;

    @FindBy(xpath = "//div[text()='Popularity']")
    private WebElement Popularity;

    @FindBy(xpath = "//span[@class='BUOuZu']//span")
    private WebElement CheckResult;

    @FindBy(xpath = "//div[text()='4★ & above']")
    private WebElement FourStart;

    // Constructor
    public PageObject_Flipkart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Java_Selenium Methods/Logic Actions
    public void TestCase01 (String ProductName) {
        search.sendKeys(ProductName);
        Click_search.click();
        String searchText = CheckResult.getText();
        System.out.println(searchText);

        //Hard assertion
        assertTrue("Search text does not contain 'washing machine'", searchText.contains("Washing Machine"));
        List<WebElement> ratingElements = driver.findElements(By.xpath("//span[contains(@id,'productRating')]"));

        int count = 0;
        for (WebElement rating : ratingElements) {
            double ratingValue = Double.parseDouble(rating.getText().trim());
            if (ratingValue <= 4.0) {
                count++;
            }
        }
        System.out.println("count of items with rating less than or equal to 4 stars : " + count);
    }

    public void TestCase02(String ProductName) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        search.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(search).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();

        search.sendKeys(ProductName);
        search.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        String SearchText = CheckResult.getText();

        //Hard assertion
        assertTrue("Typed iPhone is not into search box", SearchText.contains("iPhone"));
        Thread.sleep(3000);
        List<WebElement> discountElements = driver.findElements(By.xpath("//div[@class='tUxRFH']"));

        for (WebElement discountElement : discountElements) {

            WebElement titleElement = discountElement.findElement(By.xpath(".//div[@class='KzDlHZ']"));
            String title = titleElement.getText();

            WebElement discountTextElement = discountElement.findElement(By.xpath(".//div[@class='UkUFwK']//span"));
            String discountText = discountTextElement.getText();

            int discount = Integer.parseInt(discountText.replaceAll("[^0-9]", ""));
            if (discount > 5) {
                System.out.println("Title : " + title + " : " + discount);
            }
        }
    }

    public void TestCase03(String ProductName) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        search.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(search).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();

        search.sendKeys(ProductName);
        search.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        String SearchText = CheckResult.getText();

        //Hard assertion
        assertTrue("Typed Coffee Mug is not into search box", SearchText.contains("Coffee Mug"));
        FourStart.click();
        String URL = driver.getCurrentUrl();

        //Hard assertion
        assertTrue("above 4start product is not display", URL.contains("above"));
        Thread.sleep(5000);

        List<WebElement> Review = driver.findElements(By.xpath("//div[contains(@class, 'slAVV')]//span[contains(@class,'Wphh')]"));
        List<WebElement> ImageURL = driver.findElements(By.xpath("//img[@class='DByuf4']"));
        List<WebElement> Title = driver.findElements(By.xpath("//a[@class='wjcEIp']"));

        Map<Integer, Integer> reviewIndexMap = new HashMap<>();
        for (int i = 0; i < Review.size(); i++) {
            String reviewText = Review.get(i).getText();
            String number = reviewText.replaceAll("[^0-9]", "");
            if (!number.isEmpty()) {
                reviewIndexMap.put(i, Integer.parseInt(number));
            }
        }

        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(reviewIndexMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Top 5 Coffee Mugs based on highest reviews:");
        for (int i = 0; i < 5 && i < sortedList.size(); i++) {
            int index = sortedList.get(i).getKey();

            String title = Title.get(index).getText();
            String imgURL = ImageURL.get(index).getAttribute("src");

            System.out.println((i + 1) + ". Title: " + title);
            System.out.println("   Image URL: " + imgURL);
            System.out.println();
        }

    }

}
