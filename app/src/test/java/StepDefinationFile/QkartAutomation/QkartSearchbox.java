package StepDefinationFile.QkartAutomation;

import org.testng.annotations.Test;

import BaseTest.BaseTest;

public class QkartSearchbox extends BaseTest {

    @Test       //Verify a Search box
    public void TestCase02() throws InterruptedException {
        initializeBrowserAndPage();
        driver.get("https://crio-qkart-qa.vercel.app/");
        loginPage.Login();
        searchbox.Search("yonex", "Gesundheit");

    }

}
