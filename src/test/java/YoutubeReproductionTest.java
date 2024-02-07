import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import web.pages.HomePage;
import web.pages.VideoReproductorPage;

public class YoutubeReproductionTest implements IAbstractTest {

    @Test
    public void verifyAutoPlayVideoTest() {
        WebDriver driver = getDriver();
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        VideoReproductorPage videoReproductorPage = homePage.clickFirstVideoLink();

        softAssert.assertTrue(videoReproductorPage.videoTitleMatches(homePage.getFirstVideoTitle()),
                "Video reproductor title does not match home video title");
        Assert.assertTrue(videoReproductorPage.isVideoPlaying(), "Video reproductor was not auto played");

        softAssert.assertAll();
    }
}
