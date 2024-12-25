package src.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import src.lib.Platform;

import static src.lib.ui.SearchPageObject.*;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
        TITLE,
        ELEMENT_PAGE_WEB_VIEW,
        ELEMENT_PAGE_SAVE,
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
        ONBOARDING_ELEMENT;




    public ArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
       if (Platform.getInstance().isAndroid()){
        return title_element.getAttribute("text");
       } else if (Platform.getInstance().isIOS()){
           return title_element.getAttribute("name");
       } else {
           return title_element.getText();
       }
    }

    public void swipeToStartButton()
    {
        this.scrollToLeftFindElement(
                ONBOARDING_ELEMENT,
                "Cannot find onboarding button",
                20
        );
    }



    public void swipeToNextPageOnboarding()
    {
        this.scroll(300);
    }

    public void assertThereIsResultOfSearch()
    {
        this.assertElementPresent(TITLE, "We've not found some results by request");

    }

    public void waitElementPageWebView()
    {
        this.waitForElementAndClick(ELEMENT_PAGE_WEB_VIEW, "We've not found some results by request", 5);

    }

    public void waitElementPageSave()
    {
        if (Platform.getInstance().isMW()) {
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(ELEMENT_PAGE_SAVE, "We've not found save button", 5);

    }

    public void removeArticleFromSavedIfItAdded()
    {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove an article from saved",
                    1
            );
            this.waitForElementPresent(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to add an article to saved list after removing it from this list before"
            );
        }
    }

}
