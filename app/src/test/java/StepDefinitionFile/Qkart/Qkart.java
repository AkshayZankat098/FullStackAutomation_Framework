package StepDefinitionFile.Qkart;

import org.testng.annotations.Test;

import BaseTest.BaseTest;

public class Qkart extends BaseTest {

    @Test
    public void TestCase01() throws InterruptedException {
        System.out.println("TestCase01 : START");
        driver.get("https://crio-qkart-qa.vercel.app/");
        Qkart.TestCaseID01();
        System.out.println("TestCase01 : END : PASS");
    }

    @Test
    public void TestCase02 () throws InterruptedException {
        System.out.println("TestCase02 : START");
        Qkart.TestCaseID02("Akshay@gmail.com", "Akshay@123", "Akshay@123");
        System.out.println("TestCase02 : END : PASS");
    }

    @Test
    public void TestCase03 () throws InterruptedException {
        System.out.println("TestCase03 : START");
        Qkart.TestCaseID03("yonex", "Gesundheit");
        System.out.println("TestCase03 : END : PASS");
    }

    @Test
    public void TestCase04 () throws InterruptedException {
        System.out.println("TestCase04 : START");
        Qkart.TestCaseID04("Running Shoes");
        System.out.println("TestCase04 : END : PASS");
    }






    

}
