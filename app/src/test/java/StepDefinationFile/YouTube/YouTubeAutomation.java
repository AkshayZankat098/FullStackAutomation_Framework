package StepDefinationFile.YouTube;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import BaseTest.BaseTest;

public class YouTubeAutomation extends BaseTest {

        static SoftAssert softAssert = new SoftAssert();
        public static void SelectOption(String optionselect) {
        WebElement Option = driver.findElement(By.xpath("//a[@title='" + optionselect + "']"));
        Option.click();
    }


    public static void YouTubeHomePageTestCase () {
        driver.get("https://www.youtube.com/");

        String expectedUrl = "https://www.youtube.com/";
        String actualUrl = driver.getCurrentUrl();

        softAssert.assertEquals(actualUrl, expectedUrl, "The actual URL did not match the expected URL!");
        softAssert.assertAll();

        WebElement About = driver.findElement(By.xpath("//a[text()='About']"));
        About.click();

        List<WebElement> AboutInfo = driver.findElements(By.xpath("//p[@class='lb-font-display-3 lb-font-color-text-primary']"));
        for (WebElement webElement : AboutInfo) {
            System.out.println(webElement.getText());
        }
    }

    public static void MoviesTestCase (String optionselect) throws InterruptedException {

        // initializeDriver();
        driver.get("https://www.youtube.com/");
        SelectOption("Movies");
        Thread.sleep(10000);

        WebElement ScrollButton = driver.findElement(By.xpath("(//button[@aria-disabled='false'])[3]"));
        ScrollButton.click();
        Thread.sleep(10000);
        ScrollButton.click();

        List<WebElement> AllListMovie = driver.findElements(By.xpath("//div[@id='items' and @class='style-scope yt-horizontal-list-renderer']//ytd-grid-movie-renderer"));
        
        Thread.sleep(10000);
        WebElement LastMovie = driver.findElement(By.xpath("(//div[@id='items' and @class='style-scope yt-horizontal-list-renderer']//ytd-grid-movie-renderer//a//span)[16]"));
        String MovieText = LastMovie.getText();
        System.out.println(MovieText);

        WebElement Categoty = driver.findElement(By.xpath("(//div[@id='items' and @class='style-scope yt-horizontal-list-renderer']//ytd-grid-movie-renderer//ytd-badge-supported-renderer//div/p[@class='style-scope ytd-badge-supported-renderer'])[32]"));
        String CategotyLast = Categoty.getText();
        System.out.println(CategotyLast);

        // Soft Assert for MovieText
        boolean containsGenre = MovieText.contains("Comedy") && MovieText.contains("Animation") && MovieText.contains("Drama");
        softAssert.assertTrue(containsGenre, "Movie should contain Comedy, Animation, and Drama");
        if (containsGenre) {
            System.out.println("Movie contains Comedy, Animation, and Drama");
        } else {
            System.out.println("Movie does not contain all of Comedy, Animation, and Drama");
        }

        // Soft Assert for CategotyLast
        softAssert.assertTrue(CategotyLast.contains("A"), "CategotyLast should contain A");
        if (CategotyLast.contains("A")) {
            System.out.println("CategotyLast contains A");
        } else {
            System.out.println("CategotyLast does not contain A");
        }

    }
        

    public static void MusicTestCase () throws InterruptedException {

        // initializeDriver();
        // driver.get("https://www.youtube.com/");
        SelectOption("Music");

        Thread.sleep(3000);
        WebElement MusicPlaylistName = driver.findElement(By.xpath("//div[@class='yt-lockup-metadata-view-model-wiz__text-container']//h3[@title='Tollywood Hitlist']"));
        String name = MusicPlaylistName.getText();
        System.out.println("Playlist music name is : " + name);

        WebElement MusicNo = driver.findElement(By.xpath("(//yt-thumbnail-badge-view-model[contains(@class, 'yt-thumbnail-badge-view-model-wiz')]//div[contains(@class, 'badge-shape-wiz__text')])[4]"));
        String Count = MusicNo.getText();
        int trackCount = Integer.parseInt(Count.replaceAll("[^0-9]", ""));
        System.out.println("Number of tracks: " + trackCount);

        softAssert.assertTrue(trackCount <= 50,"Number of tracks in " + MusicPlaylistName + " is greater than 50: " + trackCount);
        softAssert.assertAll();
    }

    public static void NewsTestCase () throws InterruptedException {

        // initializeDriver();
        // driver.get("https://www.youtube.com/");
        SelectOption("News");
        Thread.sleep(8000);

        List<WebElement> titles = driver.findElements(By.xpath("//div[@id='body']//div[@id='post-text']//yt-formatted-string[@id='home-content-text']"));
        List<WebElement> Likes = driver.findElements(By.xpath("//span[@id='vote-count-middle']"));

        for (int i = 1; i < 3; i++) {
            WebElement titleElement = titles.get(i);
            String title = titleElement.getText();
            System.out.println(title);
            String LikeA = driver.findElement(By.xpath("(//span[@id='vote-count-middle'])[" + i + "]")).getText();
            System.out.println(LikeA);
        }

        int count = 0;
        for (int j = 0; j < 3; j++) {
            WebElement LikesElement = Likes.get(j);
            String Like = LikesElement.getText();
            int likeCount = Integer.parseInt(Like);
            count = count + likeCount;
        }

        System.out.println(count);
    }

}
