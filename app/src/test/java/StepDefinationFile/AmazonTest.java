package StepDefinationFile;

import org.testng.annotations.Test;

import BaseTest.BaseTest;

public class AmazonTest extends BaseTest {

    @Test
    public void TestCase01() throws InterruptedException {

        initializeBrowserAndPage();
        driver.get("https://www.amazon.in/");
        Amazon.Search_Case("headphones");

    }
}
