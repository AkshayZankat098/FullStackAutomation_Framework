package PageObjectFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Practice_POM {

    private WebDriver driver;

    // Constructor
    public Practice_POM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    

}
