package web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class VideoReproductorPage extends AbstractPage {

    @FindBy(css = "#title h1")
    private ExtendedWebElement videoTitle;

    @FindBy(xpath = "//div[@id = 'player-container']//div[contains(@class, 'html5-video-player')][1]")
    private ExtendedWebElement videoPlayer;

    public VideoReproductorPage(WebDriver driver) {
        super(driver);
    }

    public String getVideoTitleText() {
        return videoTitle.getText();
    }

    public boolean videoTitleMatches(String text) {
        return getVideoTitleText().equalsIgnoreCase(text);
    }

    public String getVideoPlayerClasses() {
        return videoPlayer.getAttribute("class");
    }

    public boolean isVideoPlaying() {
        return getVideoPlayerClasses().contains("playing-mode");
    }
}
