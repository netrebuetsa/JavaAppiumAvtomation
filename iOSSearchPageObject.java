package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_BUTTON_SKIP = "xpath://XCUIElementTypeButton[@name='Skip']";
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_INPUT = "id:Search Wikipedia";
        SEARCH_CANCEL_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
        SEARCH_CLOSE_BUTTON = "id:Clear text";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeOther";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";
       // SEARCH_LIST_ITEM_TITLE = "id:org.wikipedia:id/page_list_item_title";
        SEARCH_TITLE_ONBOARDING_LIST1 = "id:The free encyclopedia";
        SEARCH_TITLE_ONBOARDING_LIST2 = "id:New ways to explore";
        SEARCH_TITLE_ONBOARDING_LIST3 = "id:Search in nearly 300 languages";
        SEARCH_TITLE_ONBOARDING_LIST4 = "id:Help make the app better";
        SEARCH_ONBOARDING_DONE_BUTTON = "xpath://XCUIElementTypeButton[@name='Get started']";
        SEARCH_MAIN_TOOLBAR_WORDMARK = "id:wikipedia";
       // SEARCH_NAVIGATION_BAR_SAVE_ICON = "xpath://*[@resource-id='org.wikipedia:id/navigation_bar_item_small_label_view'][@text = 'Saved']";
       // SEARCH_SAVED_OBJECT = "id:org.wikipedia:id/item_title";
        TITLE = "id:Java (programming language)";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name, '{SUBSTRING}')]";
    }

    public iOSSearchPageObject(AppiumDriver driver){
        super(driver);
    }
}
