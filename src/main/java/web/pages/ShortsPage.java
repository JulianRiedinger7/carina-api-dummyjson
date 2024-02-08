package web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.components.ShortVideo;

import java.time.Duration;
import java.util.List;

public class ShortsPage extends AbstractPage {

    @FindBy(css = "#shorts-container")
    private List<ShortVideo> shortVideos;

    @FindBy(css = "#contentWrapper ytd-modal-with-title-and-button-renderer")
    private ExtendedWebElement likeModal;

    public ShortsPage(WebDriver driver) {
        super(driver);
    }

    public List<ShortVideo> getShortVideos() {
        return shortVideos;
    }

    public int getShortVideosSize() {
        return shortVideos.size();
    }

    public ShortVideo getFirstShortVideo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return getShortVideosSize() > 0;
            }
        });
        return shortVideos.get(0);
    }

    public boolean isLikeModalVisible() {
        return likeModal.isVisible();
    }
}
