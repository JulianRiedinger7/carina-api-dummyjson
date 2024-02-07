package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.pages.ShortsPage;

public class Sidebar extends AbstractUIObject {

    @FindBy(css = "a[title='Shorts']")
    private ExtendedWebElement shortsLink;

    public Sidebar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ShortsPage clickShortsLink() {
        shortsLink.click();
        return new ShortsPage(driver);
    }
}
