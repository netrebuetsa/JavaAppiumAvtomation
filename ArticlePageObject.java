package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
        TITLE = "//*[contains(@text, 'Java (programming language)')]",
        ELEMENT_PAGE_WEB_VIEW = "org.wikipedia:id/page_web_view",
        ONBOARDING_ELEMENT = "org.wikipedia:id/fragment_onboarding_done_button";

    public ArticlePageObject(AppiumDriver driver){
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.xpath(TITLE), "Cannot find article title on page", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToStartButton()
    {
        this.scrollToLeftFindElement(
                By.id(ONBOARDING_ELEMENT),
                "Cannot find onboarding button",
                20
        );
    }

    public void swipeToNextPageOnboarding()
    {
        this.scroll(200);
    }

    public void assertThereIsResultOfSearch()
    {
        this.assertElementPresent(By.xpath(TITLE), "We've not found some results by request");

    }

    public void waitElementPageWebView()
    {
        this.waitForElementAndClick(By.id(ELEMENT_PAGE_WEB_VIEW), "We've not found some results by request", 5);

    }

}
