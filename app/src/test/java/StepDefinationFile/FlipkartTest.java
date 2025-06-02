package StepDefinationFile;

import org.testng.annotations.Test;

import BaseTest.BaseTest;

public class FlipkartTest extends BaseTest {

    @Test
    public void TestCase01() throws InterruptedException {

        initializeBrowserAndPage();
        driver.get("https://www.flipkart.com/");
        flipkart.Search_Case("headphones");
        flipkart.GetTen_Product();

    }
}
