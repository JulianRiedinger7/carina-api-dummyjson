package web.pages;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.components.Header;
import web.components.Sidebar;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(id = "masthead-container")
    private Header header;

    @FindBy(id = "sections")
    private Sidebar sidebar;

    @FindBy(xpath = "//div[@id = 'contents']//a[@id = 'video-title-link']")
    private List<ExtendedWebElement> videoLinks;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }

    public Header getHeader() {
        return header;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }

    private ExtendedWebElement firstVideoLink() {
        return videoLinks.get(0);
    }

    public String getFirstVideoTitle() {
        return firstVideoLink().getAttribute("title");
    }

    public VideoReproductorPage clickFirstVideoLink() {
        firstVideoLink().click();
        return new VideoReproductorPage(driver);
    }


}
