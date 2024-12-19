package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
                SEARCH_BUTTON_SKIP = "xpath://*[contains(@text, 'Skip')]";
                SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
                SEARCH_INPUT = "xpath://*[contains(@text, 'Search Wikipedia')]";
                SEARCH_CANCEL_BUTTON = "xpath://lib.ui.android.widget.ImageButton[@content-desc=\"Navigate up\"]";
                SEARCH_CLOSE_BUTTON = "id:org.wikipedia:id/search_close_btn";
                SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text = 'Linkin Park discography']";
                SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results']";
                SEARCH_LIST_ITEM_TITLE = "id:org.wikipedia:id/page_list_item_title";
                SEARCH_TITLE_ONBOARDING_LIST1 = "xpath://*[@resource-id='org.wikipedia:id/primaryTextView'][contains(@text, 'The Free Encyclopedia\n…in over 300 languages')]";
                SEARCH_TITLE_ONBOARDING_LIST2 = "xpath://*[@resource-id='org.wikipedia:id/primaryTextView'][@text = 'New ways to explore']";
                SEARCH_TITLE_ONBOARDING_LIST3 = "xpath://*[@resource-id='org.wikipedia:id/primaryTextView'][@text = 'Reading lists with sync']";
                SEARCH_TITLE_ONBOARDING_LIST4 = "xpath://*[@resource-id='org.wikipedia:id/primaryTextView'][@text = 'Data & Privacy']";
                SEARCH_ONBOARDING_DONE_BUTTON = "id:org.wikipedia:id/fragment_onboarding_done_button";
                SEARCH_MAIN_TOOLBAR_WORDMARK = "id:org.wikipedia:id/main_toolbar_wordmark";
                SEARCH_NAVIGATION_BAR_SAVE_ICON = "xpath://*[@resource-id='org.wikipedia:id/navigation_bar_item_small_label_view'][@text = 'Saved']";
                SEARCH_SAVED_OBJECT = "id:org.wikipedia:id/item_title";
                TITLE = "xpath://*[contains(@text, 'Java (programming language)')]";
                SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description'][@text = '{SUBSTRING}']";
    }

    public AndroidSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
