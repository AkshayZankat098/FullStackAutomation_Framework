package StepDefinationFile;

import org.testng.annotations.Test;
import BaseTest.BaseTest;

public class QkartLogin extends BaseTest {

    @Test       //Verify a new user can successfully register
    public void TestCase01() {
        initializeBrowserAndPage();
        driver.get("https://crio-qkart-qa.vercel.app/");
        loginPage.Registration();
    }

}
