package web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.pages.HomePage;
import web.pages.SearchResultsPage;
import web.pages.ShortsPage;

public class Header extends AbstractUIObject {

    @FindBy(css = "input#search")
    private ExtendedWebElement searchInput;

    @FindBy(id = "search-icon-legacy")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//div[@id = 'container']//a[@id = 'logo']")
    private ExtendedWebElement youtubeLogo;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void enterSearchText(String text) {
        searchInput.type(text);
    }

    public SearchResultsPage clickSearchBtn() {
        searchBtn.click();
        return new SearchResultsPage(driver);
    }

    public HomePage goToHome() {
        youtubeLogo.click();
        return new HomePage(driver);
    }
}
