import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import web.components.Header;
import web.components.ShortVideo;
import web.components.Sidebar;
import web.pages.HomePage;
import web.pages.ShortsPage;

import java.time.Duration;

public class YoutubeShortsTest implements IAbstractTest {

    @Test
    public void verifyShortIsVisibleAndCannotBeLikedTest() {
        WebDriver driver = getDriver();
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        Sidebar sidebar = homePage.getSidebar();
        softAssert.assertTrue(sidebar.isUIObjectPresent(2), "Side bar was not found");

        ShortsPage shortsPage = sidebar.clickShortsLink();
        ShortVideo shortVideo = shortsPage.getFirstShortVideo();
        softAssert.assertTrue(driver.getCurrentUrl().contains("shorts"), "The url does not contain shorts keyword");
        softAssert.assertTrue(shortVideo.isPlayerVisible(), "The short video player is not visible");

        shortVideo.clickLikeBtn();
        Assert.assertTrue(shortsPage.isLikeModalVisible(), "The access to like modal is not visible");

        softAssert.assertAll();
    }
}
