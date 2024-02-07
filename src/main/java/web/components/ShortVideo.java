package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShortVideo extends AbstractUIObject {

    @FindBy(css = "ytd-player#player")
    private ExtendedWebElement player;

    @FindBy(css = "ytd-toggle-button-renderer#like-button")
    private ExtendedWebElement likeBtn;

    public ShortVideo(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isPlayerVisible() {
        return player.isVisible();
    }

    public void clickLikeBtn() {
        likeBtn.click();
    }

}
