package StepDefinationFile.QkartAutomation;

import org.testng.annotations.Test;

import BaseTest.BaseTest;

public class QkartLogin extends BaseTest {

    @Test       //Verify a new user can successfully register
    public void TestCase01() throws InterruptedException {
        initializeBrowserAndPage();
        driver.get("https://crio-qkart-qa.vercel.app/");

        registration.Registration("AkshayZankat@gmail.com", "Akshay@123", "Akshay@123");
        loginPage.Login();
        registration.registerWithOld_User();
    }


    

}
