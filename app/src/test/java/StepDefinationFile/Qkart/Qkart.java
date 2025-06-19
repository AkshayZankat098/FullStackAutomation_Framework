package StepDefinationFile.Qkart;

import org.testng.annotations.Test;

import BaseTest.BaseTest;

public class Qkart extends BaseTest {

    @Test
    public void TestCase01() throws InterruptedException {
        System.out.println("TestCase01 : START");
        initializeBrowserAndPage();
        driver.get("https://crio-qkart-qa.vercel.app/");
        Qkart.Login();
        System.out.println("TestCase01 : END : PASS");
    }

    @Test
    public void TestCase02 () throws InterruptedException {
        System.out.println("TestCase02 : START");
        Qkart.registerWithOld_User("Akshay@gmail.com", "Akshay@123", "Akshay@123");
        System.out.println("TestCase02 : END : PASS");
    }

    @Test
    public void TestCase03 () throws InterruptedException {
        System.out.println("TestCase03 : START");
        Qkart.Search("Akshay", "Zankat");
        System.out.println("TestCase03 : END : PASS");
    }




    

}
