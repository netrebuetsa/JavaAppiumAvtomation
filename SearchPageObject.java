package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject
{

    private static final String
        SEARCH_BUTTON_SKIP = "//*[contains(@text, 'Skip')]",
        SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
        SEARCH_INPUT = "//*[contains(@text, 'Search Wikipedia')]",
        SEARCH_CANCEL_BUTTON = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]",
        SEARCH_CLOSE_BUTTON = "org.wikipedia:id/search_close_btn",
        SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text = 'Linkin Park discography']",
        SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results']",
        SEARCH_LIST_ITEM_TITLE = "org.wikipedia:id/page_list_item_title",
        SEARCH_TITLE_ONBOARDING_LIST1 = "//*[@resource-id='org.wikipedia:id/primaryTextView'][contains(@text, 'The Free Encyclopedia\n…in over 300 languages')]",
        SEARCH_TITLE_ONBOARDING_LIST2 = "//*[@resource-id='org.wikipedia:id/primaryTextView'][@text = 'New ways to explore']",
        SEARCH_TITLE_ONBOARDING_LIST3 = "//*[@resource-id='org.wikipedia:id/primaryTextView'][@text = 'Reading lists with sync']",
        SEARCH_TITLE_ONBOARDING_LIST4 = "//*[@resource-id='org.wikipedia:id/primaryTextView'][@text = 'Data & Privacy']",
        SEARCH_ONBOARDING_DONE_BUTTON = "org.wikipedia:id/fragment_onboarding_done_button",
        SEARCH_MAIN_TOOLBAR_WORDMARK = "org.wikipedia:id/main_toolbar_wordmark",
        SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_description'][@text = '{SUBSTRING}']";


    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS*/
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    public void initSkipButton() {
        this.waitForElementPresent(By.xpath(SEARCH_BUTTON_SKIP), "Cannot find button 'Skip'");
        this.waitForElementAndClick(By.xpath(SEARCH_BUTTON_SKIP), "Cannot find button 'Skip'", 5);
    }

    public void initSearchInput() {
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
    }

    public void typeSearchLine(String search_line) {

        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find search input", 5);
    }

    public void waitForSearchResult(String substring) {

        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath),  "Cannot find search result");
    }

    public void waitForCancelButtonToAppear() {

        this.waitForElementPresent(By.xpath(SEARCH_CANCEL_BUTTON), "Cannot find X to cancel search", 5);
    }

    public void waitForTitleOnboardingList1() {

        this.waitForElementPresent(By.xpath(SEARCH_TITLE_ONBOARDING_LIST1),
                "Cannot find tittle on first page onboarding",
                5);
    }

    public void waitForTitleOnboardingList2() {

        this.waitForElementPresent(By.xpath(SEARCH_TITLE_ONBOARDING_LIST2),
                "Cannot find tittle on second page onboarding",
                5);
    }

    public void waitForTitleOnboardingList3() {

        this.waitForElementPresent(By.xpath(SEARCH_TITLE_ONBOARDING_LIST3),
                "Cannot find tittle on third page onboarding",
                5);
    }

    public void waitForTitleOnboardingList4() {

        this.waitForElementPresent(By.xpath(SEARCH_TITLE_ONBOARDING_LIST4),
                "Cannot find tittle on fourth page onboarding",
                5);
    }

    public void waitForMainToolbar() {

        this.waitForElementPresent(By.id(SEARCH_MAIN_TOOLBAR_WORDMARK),
                "Cannot find main toolbar wordmark",
                5);
    }

    public void clickDoneButtonOnboarding() {

        this.waitForElementAndClick(By.id(SEARCH_ONBOARDING_DONE_BUTTON), "Cannot find and click done button", 5);
    }


    public void waitForCancelButtonToDisappear() {

        this.waitForElementNotPresent(By.xpath(SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 5);
    }

    public void waitForCancelSearch() {

        this.waitForElementNotPresent(By.id(SEARCH_LIST_ITEM_TITLE), "Article is still present on the page", 5);
    }

    public void clickCancelSearch() {

        this.waitForElementAndClick(By.xpath(SEARCH_CANCEL_BUTTON), "Cannot find and click search cancel button", 5);
    }

    public void clickCloseSearch() {

        this.waitForElementAndClick(By.id(SEARCH_CLOSE_BUTTON), "Cannot find and click search close button", 5);
    }

    public void clickByArticleWithSubstring(String substring) {

        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath),  "Cannot find and click search result with substring" + substring, 10);
    }

    public int getAmountOfFoundArticle()
    {

        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by the request ",
                15
        );

        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultLabel()
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot find empty result element", 15);

    }

    public void assertThereIsNoResultOfSearch()
    {
        this.waitForElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT), "We supposed not to find any results", 15);

    }


}
