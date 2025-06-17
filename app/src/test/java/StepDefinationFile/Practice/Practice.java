package StepDefinationFile.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import BaseTest.BaseTest;

public class Practice extends BaseTest {

    @Test
    public void TestCase01() {

        initializeBrowserAndPage();
        driver.get("http://192.168.27.132/COSEC/Login/Login");

        // Open new tab
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);

        // Open another URL in second tab
        driver.get("http://192.168.27.132/COSEC/Login/Login");

        Set<String> windowIDs = driver.getWindowHandles();
        List<String> ids = new ArrayList<>(windowIDs);

        driver.switchTo().window(ids.get(0));
        driver.findElement(By.id("loginid")).sendKeys("Sa");

        System.out.println(windowIDs);
        System.out.println(ids);

    }

}
