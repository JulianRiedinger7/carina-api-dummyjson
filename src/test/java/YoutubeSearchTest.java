import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import web.components.Header;
import web.pages.HomePage;
import web.pages.SearchResultsPage;

import java.time.Duration;

public class YoutubeSearchTest implements IAbstractTest {

    @DataProvider(name = "Search keywords")
    public Object[][] dataprovider() {
        return new Object[][] {
                {"testing"},
                {"selenium"},
                {"java"}
        };
    }

    @Test(dataProvider = "Search keywords")
    public void verifyCorrectVideoTitleWhenSearchingTest(String keyword) {
        WebDriver driver = getDriver();
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        Header header = homePage.getHeader();
        softAssert.assertTrue(header.isUIObjectPresent(2), "Header was not found");

        header.enterSearchText(keyword);
        SearchResultsPage searchResultsPage = header.clickSearchBtn();

        softAssert.assertTrue(driver.getCurrentUrl().contains(keyword),
                String.format("The url does not contain '%s' search criteria", keyword));

        Assert.assertTrue(searchResultsPage.firstVideoTitleContains(keyword),
                String.format("The video title does not contain '%s' search criteria", keyword));
        softAssert.assertAll();
    }
}
