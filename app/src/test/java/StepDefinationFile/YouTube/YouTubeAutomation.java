package StepDefinationFile.YouTube;
import org.testng.annotations.Test;
import BaseTest.BaseTest;

public class YouTubeAutomation extends BaseTest {

    @Test
    public void TestCase01 () {
        System.out.println("TestCase01 :: YouTubeHomePageTestCase : START");
        youTube.TestCase01();
        System.out.println("TestCase01 : END : PASS");
    }

    @Test
    public void TestCase02 ( ) throws InterruptedException {
        System.out.println("TestCase02 :: MoviesTestCase : START");
        youTube.TestCase02();
        System.out.println("TestCase02 : END : PASS");

    }
        
    @Test
    public void TestCase03 () throws InterruptedException {
        System.out.println("TestCase03 :: MusicTestCase : START");
        youTube.TestCase03();
        System.out.println("TestCase03 : END : PASS");
    }

    @Test
    public void TestCase04 () throws InterruptedException {
        System.out.println("TestCase04 :: NewsTestCase : START");
        youTube.TestCase04();
        System.out.println("TestCase04 : END : PASS");
    }
}
