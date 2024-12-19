package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;


public class HomeWorkEx5Refactor extends CoreTestCase {

    @Test
    public void testSwipeElementAndCheckTitle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.waitForTitleOnboardingList1();
        SearchPageObject.swipeToSecondOnboardingList();
        SearchPageObject.waitForTitleOnboardingList2();
        SearchPageObject.swipeToThirdOnboardingList();
        SearchPageObject.waitForTitleOnboardingList3();
        SearchPageObject.swipeToFourthOnboardingList();
        SearchPageObject.waitForTitleOnboardingList4();
        SearchPageObject.clickDoneButtonOnboarding();
        SearchPageObject.waitForMainToolbar();
    }
}
