package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject {

    private static final String
    STEP_LEARN_MORE_LINK = "id:Wikipedia is written collaboratively by volunteers and consists of more than 40 million articles in nearly 300 languages.",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New ways to explore",
    STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "id:Search in nearly 300 languages",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTION = "id:Help make the app better",
    NEXT_LINK = "xpath://XCUIElementTypeButton[@name=\"Next\"]",
    GET_STARTED_BUTTON = "xpath:///XCUIElementTypeButton[@name=\"Get started\"]";

    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink(){

        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Cannot find text", 10);
    }

    public void waitForNewWayToExploreText(){

        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT, "Cannot find 'New ways to explore'text", 10);
    }

    public void waitForAddOrEditPreferredLangText(){

        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK, "Cannot find 'Search in nearly 300 languages' text", 10);
    }

    public void waitForALearnMoreAboutDataCollectedText(){

        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTION, "Cannot find 'Help make the app better' text", 10);
    }

    public void clickNextButton(){

        this.waitForElementAndClick(NEXT_LINK, "Cannot find and click next link", 10);
    }

    public void clickGetStartedButton(){

        this.waitForElementAndClick(GET_STARTED_BUTTON, "Cannot find and click Get started button", 10);
    }
}
