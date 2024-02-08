package web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//div[@id = 'contents']//*[self::a[@id = 'video-title'] or self::span[contains(@class, 'ytd-playlist-renderer')]]")
    private List<ExtendedWebElement> videoTitles;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getVideoTitlesSize() {
        return videoTitles.size();
    }

    private String getFirstVideoTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return getVideoTitlesSize() > 0;
            }
        });
        if (videoTitles.isEmpty()) {
            return "No video titles found";
        } else {
            ExtendedWebElement firstVideoTitle = videoTitles.get(0);
            return firstVideoTitle.getAttribute("title");
        }
    }

    public boolean firstVideoTitleContains(String keyword) {
        return getFirstVideoTitle().toLowerCase().contains(keyword.toLowerCase());
    }
}
