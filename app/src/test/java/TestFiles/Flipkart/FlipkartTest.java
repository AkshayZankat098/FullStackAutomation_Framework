package TestFiles.Flipkart;
import org.testng.annotations.Test;
import BaseTest.BaseTest;


public class FlipkartTest extends BaseTest {

    @Test
    // TestCase01: Go to www.flipkart.com. Search "Washing Machine". Sort by popularity and print the count of items with rating less than or equal to 4 stars.

    public void TestCase01() throws InterruptedException {

        System.out.println("Test Case01 : START");
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





























/*
public class FlipkartTest extends BaseTest {

    @Given("User launches Flipkart website")
    public void user_launches_flipkart_website() {
        System.out.println("Flipkart website launched");
    }

    @When("User searches for Washing Machine and sorts by popularity")
    public void user_searches_for_washing_machine_and_sorts_by_popularity() throws InterruptedException {

        System.out.println("Test Case01 : START");
        flipkart.TestCase01("Washing Machine");
        System.out.println("Test Case01 : END : PASS");
    }

    @Then("Print count of items having rating less than or equal to 4 stars")
    public void print_count_of_items_having_rating_less_than_or_equal_to_4_stars() {
        System.out.println("Count printed successfully");
    }

    @When("User searches for iPhone")
    public void user_searches_for_iphone() throws InterruptedException {

        System.out.println("Test Case02 : START");
        flipkart.TestCase02("iPhone");
        System.out.println("Test Case02 : END : PASS");
    }

    @Then("Print title and discount percentage of items having more than 17 percent discount")
    public void print_title_and_discount_percentage_of_items_having_more_than_17_percent_discount() {
        System.out.println("Title and discount percentage printed successfully");
    }

    @When("User searches for Coffee Mug and selects 4 stars and above")
    public void user_searches_for_coffee_mug_and_selects_4_stars_and_above() throws InterruptedException {

        System.out.println("Test Case03 : START");
        flipkart.TestCase03("Coffee Mug");
        System.out.println("Test Case03 : END : PASS");
    }

    @Then("Print title and image URL of top 5 products with highest reviews")
    public void print_title_and_image_url_of_top_5_products_with_highest_reviews() {
        System.out.println("Title and Image URL printed successfully");
    }
}
*/