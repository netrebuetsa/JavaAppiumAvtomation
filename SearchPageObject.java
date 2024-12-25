package src.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import src.lib.Platform;

abstract public class SearchPageObject extends MainPageObject
{

    protected static String
        SEARCH_BUTTON_SKIP,
        SEARCH_INIT_ELEMENT,
        SEARCH_INPUT,
        SEARCH_CANCEL_BUTTON,
        SEARCH_CLOSE_BUTTON,
        SEARCH_CLOSE_BUTTON_2,
        SEARCH_BACK_BUTTON,
        SEARCH_RESULT_ELEMENT,
        SEARCH_EMPTY_RESULT_ELEMENT,
        SEARCH_LIST_ITEM_TITLE,
        SEARCH_TITLE_ONBOARDING_LIST1,
        SEARCH_TITLE_ONBOARDING_LIST2,
        SEARCH_TITLE_ONBOARDING_LIST3,
        SEARCH_TITLE_ONBOARDING_LIST4,
        SEARCH_ONBOARDING_DONE_BUTTON,
        SEARCH_MAIN_TOOLBAR_WORDMARK,
        SEARCH_NAVIGATION_BAR_SAVE_ICON,
        SEARCH_SAVED_OBJECT,
        TITLE,
        OPEN_NAVIGATION,
        REMOVE_FROM_SAVED_BUTTON,
        ARTICLE_BY_TITLE_TPL,
        SEARCH_RESULT_BY_SUBSTRING_TPL;


    public void openNavigation()
    {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button", 5);
        } else {
            System.out.println("Method openNavigation() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }
    public SearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS*/
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getArticleTitleXPath(String article_title){
        return ARTICLE_BY_TITLE_TPL.replace("{ARTICLE_TITLE}", article_title);
    }

    public void initSkipButton() {
        this.waitForElementPresent(SEARCH_BUTTON_SKIP, "Cannot find button 'Skip'");
        this.waitForElementAndClick(SEARCH_BUTTON_SKIP, "Cannot find button 'Skip'", 15);
    }

    public void initSearchInput() {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element", 15);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 15);
    }

    public void typeSearchLine(String search_line) {

        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find search input", 5);
    }

    public void waitForSearchResult(String substring) {

        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath,  "Cannot find search result");
    }

    public void waitForCancelButtonToAppear() {

        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find X to cancel search", 5);
    }

    public void waitForTitleOnboardingList1() {

        this.waitForElementPresent(SEARCH_TITLE_ONBOARDING_LIST1,
                "Cannot find tittle on first page onboarding",
                5);
    }

    public void waitForTitleOnboardingList2() {

        this.waitForElementPresent(SEARCH_TITLE_ONBOARDING_LIST2,
                "Cannot find tittle on second page onboarding",
                5);
    }

    public void waitForTitleOnboardingList3() {

        this.waitForElementPresent(SEARCH_TITLE_ONBOARDING_LIST3,
                "Cannot find tittle on third page onboarding",
                5);
    }

    public void waitForTitleOnboardingList4() {

        this.waitForElementPresent(SEARCH_TITLE_ONBOARDING_LIST4,
                "Cannot find tittle on fourth page onboarding",
                5);
    }

    public void waitForMainToolbar() {

        this.waitForElementPresent(SEARCH_MAIN_TOOLBAR_WORDMARK,
                "Cannot find main toolbar wordmark",
                5);
    }

    public void clickDoneButtonOnboarding() {

        this.waitForElementAndClick(SEARCH_ONBOARDING_DONE_BUTTON, "Cannot find and click done button", 5);
    }


    public void waitForCancelButtonToDisappear() {

        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }

    public void waitForCancelSearch() {

        this.waitForElementNotPresent(SEARCH_LIST_ITEM_TITLE, "Article is still present on the page", 5);
    }

    public void clickCancelSearch() {
        if ((Platform.getInstance().isIOS() || Platform.getInstance().isAndroid())) {

            this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
        } else {
            System.out.println("Method clickCancelSearch() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickBackButton() {

        this.waitForElementAndClick(SEARCH_BACK_BUTTON, "Cannot find and click back button", 5);
    }

    public void clickCloseButton() {

        this.waitForElementAndClick(SEARCH_CLOSE_BUTTON_2, "Cannot find and click close button", 5);
    }

    public void clickCloseSearch() {

        this.waitForElementAndClick(SEARCH_CLOSE_BUTTON, "Cannot find and click search close button", 5);
    }

    public void clickByArticleWithSubstring(String substring) {

        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath,  "Cannot find and click search result with substring" + substring, 10);
    }

    public int getAmountOfFoundArticle()
    {

        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request ",
                15
        );

        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultLabel()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element", 15);

    }

    public void assertThereIsNoResultOfSearch()
    {
        this.waitForElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results", 15);

    }

    public void waitNavigationBarSaveButton()
    {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(
                    SEARCH_NAVIGATION_BAR_SAVE_ICON,
                    "Cannot find save button navigation bar",
                    5
            );
        } else {
            this.waitForElementAndClick(SEARCH_NAVIGATION_BAR_SAVE_ICON, "Cannot find save button navigation bar", 5);
        }
    }

    public void waitSaveObject()
    {
        this.waitForElementAndClick(SEARCH_SAVED_OBJECT, "Cannot find saved object", 5);
    }

    public void swipeSaveObject() {
        if ((Platform.getInstance().isAndroid() || Platform.getInstance().isIOS())) {
            this.swipeElementToLeft(TITLE, "Cannot find saved object");
        } else {
            String remove_locator = getRemoveButtonByTitle("article_title");
            this.waitForElementAndClick(
                    remove_locator,
                    "Cannot click button to remove article fron saved",
                    10
            );
        }
        if (Platform.getInstance().isMW()) {
            driver.navigate().refresh();
        }
    }

    public void swipeSaveArticleObject(String article_title) {
        String article_title_xpath = getArticleTitleXPath(article_title);
        this.waitForArticleToAppearByTitle(article_title);

        if ((Platform.getInstance().isAndroid() || Platform.getInstance().isIOS())) {
            this.swipeElementToLeft(article_title_xpath,
                    "'" + article_title + "' article not found in the saved list");
        } else {
            String remove_locator = getRemoveButtonByTitle("article_title");
            this.waitForElementAndClick(
                    remove_locator,
                    "Cannot click button to remove article fron saved",
                    10
            );
        }
        if (Platform.getInstance().isMW()) {
            driver.navigate().refresh();
        }
    }

    private static String getRemoveButtonByTitle(String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    public void swipeToSecondOnboardingList()
    {
        this.scrollToLeftFindElement(
                SEARCH_TITLE_ONBOARDING_LIST2,
                "Cannot find tittle on second page onboarding",
                20
        );
    }

    public void swipeToFourthOnboardingList()
    {
        this.scrollToLeftFindElement(
                SEARCH_TITLE_ONBOARDING_LIST4,
                "Cannot find tittle on fourth page onboarding",
                20
        );
    }

    public void swipeToThirdOnboardingList()
    {
        this.scrollToLeftFindElement(
                SEARCH_TITLE_ONBOARDING_LIST3,
                "Cannot find tittle on third page onboarding",
                20
        );
    }

    public void waitForArticleToDisappearByTitle(String article_title){
        String article_title_xpath = this.getArticleTitleXPath(article_title);
        this.waitForElementNotPresent(article_title_xpath,
                "'"+ article_title + "' still present in the saved list",
                15);
    }

    public void waitForArticleToAppearByTitle(String article_title){
        String article_title_xpath = getArticleTitleXPath(article_title);
        this.waitForElementPresent(article_title_xpath,
                "'"+ article_title + "' article was not found in the saved list",
                15);
    }






}
