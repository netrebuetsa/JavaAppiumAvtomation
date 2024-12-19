package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class SearchPageObject extends MainPageObject
{

    protected static String
        SEARCH_BUTTON_SKIP,
        SEARCH_INIT_ELEMENT,
        SEARCH_INPUT,
        SEARCH_CANCEL_BUTTON,
        SEARCH_CLOSE_BUTTON,
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
        SEARCH_RESULT_BY_SUBSTRING_TPL;


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

        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
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
        this.waitForElementAndClick(SEARCH_NAVIGATION_BAR_SAVE_ICON, "Cannot find save button navigation bar", 5);
    }

    public void waitSaveObject()
    {
        this.waitForElementAndClick(SEARCH_SAVED_OBJECT, "Cannot find saved object", 5);
    }

    public void swipeSaveObject()
    {
        this.swipeElementToLeft(TITLE, "Cannot find saved object");
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


}
