package StepDefinitionFile.Flipkart;

import org.testng.annotations.Test;

import BaseTest.BaseTest;

public class FlipkartTest extends BaseTest {

    @Test
    // TestCase01 : Go to www.flipkart.com. Search "Washing Machine". Sort by popularity and print the count of items with rating less than or equal to 4 stars.

    public void TestCase01() throws InterruptedException {

        System.out.println("Test Case01 : START");
        initializeBrowserAndPage();
        flipkart.TestCase01("Washing Machine");
        System.out.println("Test Case01 : END : PASS");

    }

    @Test
    // TestCase02 :  Search "iPhone", print the Titles and discount % of items with more than 17% discount

    public void TestCase02() throws InterruptedException {

        System.out.println("Test Case02 : START");
        flipkart.TestCase02("iPhone");
        System.out.println("Test Case02 : END : PASS");

    }

    @Test
    //TestCase03 : Search "Coffee Mug", select 4 stars and above, and print the Title and image URL of the 5 items with highest number of reviews

    public void TestCase03() throws InterruptedException {
        System.out.println("Test Case03 : START");
        flipkart.TestCase03("Coffee Mug");
        System.out.println("Test Case03 : END : PASS");
    }
}
