package StepDefinationFile.FlipkartAutomation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import BaseTest.BaseTest;

public class FlipkartTest extends BaseTest {

    @Test
    public void TestCase01() throws InterruptedException {

        initializeBrowserAndPage();
        driver.get("https://www.flipkart.com/");
        String CurrentURL = driver.getCurrentUrl();

        flipkart.Search_Case("headphones");
        flipkart.GetTen_Product();

        if (CurrentURL.contains("flipkart")) {
            System.out.println("Navigated to the flipkart");
        }

        WebElement searchBox = driver.findElement(By.name("q"));
        flipkart.clickElement(searchBox);
        searchBox.sendKeys("Washing Machine");

        String searchText = searchBox.getAttribute("value");
        System.out.println(searchText);

        if (searchText.contains("Washing Machine")) {
            System.out.println("Typed Washing Machine into search box");
        }

        WebElement Search = driver.findElement(By.xpath("//button[@type='submit']"));
        flipkart.clickElement(Search);

        WebElement Popularity = driver.findElement(By.xpath("//div[text()='Popularity']"));
        flipkart.clickElement(Popularity);

        List<WebElement> ratingElements = driver.findElements(By.xpath("//span[contains(@id,'productRating')]//div[text()<= 4.0]"));
        System.out.println("Number of rating elements <= 4.0 : " + ratingElements.size());

        System.out.println("Test Case01 : END : PASS");
        Thread.sleep(10000);

    }


    @Test
    public void testCase02 () throws InterruptedException {

        System.out.println("Test Case02 : START");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@class='_30XB9F']")).click();
        Thread.sleep(10000);

        WebElement searchBox = driver.findElement(By.name("q"));
        Thread.sleep(5000);
        flipkart.clickElement(searchBox);
        Thread.sleep(5000);
        searchBox.sendKeys("iPhone");

        String searchText = searchBox.getAttribute("value");
        System.out.println(searchText);

        if (searchText.contains("iPhone")) {
            System.out.println("Typed iPhone into search box");
        }

        WebElement Search = driver.findElement(By.xpath("//button[@type='submit']"));
        flipkart.clickElement(Search);
        
        List<WebElement> discountElements = driver.findElements(By.xpath("//div[@class='tUxRFH']"));

        for (WebElement discountElement : discountElements) {
            
            WebElement titleElement = discountElement.findElement(By.xpath(".//div[@class='KzDlHZ']"));
            String title = titleElement.getText();
        
            WebElement discountTextElement = discountElement.findElement(By.xpath("//div[@class='UkUFwK']"));
            String discountText = discountTextElement.getText();
            int discount = Integer.parseInt(discountText.replaceAll("[^0-9]", ""));
        
            if (discount > 17) {
                Thread.sleep(3000);
                System.out.println("Title : " + title + " : " + discount);
            }
        }

        System.out.println("Test Case02 : END : PASS");
        Thread.sleep(10000);
    }


    @Test   
    public void testCase03 () throws InterruptedException { 

        System.out.println("Test Case03 : START");
        Thread.sleep(10000);
        Thread.sleep(5000);

        WebElement searchBox = driver.findElement(By.name("q"));
        flipkart.clickElement(searchBox);
        Thread.sleep(5000);
        searchBox.sendKeys("Coffee Mug");

        String searchText = searchBox.getAttribute("value");
        System.out.println(searchText);

        if (searchText.contains("Coffee Mug")) {
            System.out.println("Typed Coffee Mug into search box");
        }

        WebElement Search = driver.findElement(By.xpath("//button[@type='submit']"));
        flipkart.clickElement(Search);

        WebElement Four_Above = driver.findElement(By.xpath("//div[@class='XqNaEv']"));
        flipkart.clickElement(Four_Above);

        String URL = driver.getCurrentUrl();

        if (URL.contains("above")) {
            System.out.println("above 4start product is display");
        } else {
            System.out.println("above 4start product is not display");
        }

        Thread.sleep(10000);
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
        
        System.out.println("Test Case03 : END : PASS");

    }
}
