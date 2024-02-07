package web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.components.ShortVideo;

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
        return shortVideos.get(0);
    }

    public boolean isLikeModalVisible() {
        return likeModal.isVisible();
    }
}
