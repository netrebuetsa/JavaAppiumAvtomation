package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class HomeWorkEx5Refactor extends CoreTestCase {

    @Test
    public void testSwipeElementAndCheckTitle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        SearchPageObject.waitForTitleOnboardingList1();
        ArticlePageObject.swipeToNextPageOnboarding();
        SearchPageObject.waitForTitleOnboardingList2();
        ArticlePageObject.swipeToNextPageOnboarding();
        SearchPageObject.waitForTitleOnboardingList3();
        ArticlePageObject.swipeToNextPageOnboarding();
        SearchPageObject.waitForTitleOnboardingList4();
        SearchPageObject.clickDoneButtonOnboarding();
        SearchPageObject.waitForMainToolbar();
    }
}
