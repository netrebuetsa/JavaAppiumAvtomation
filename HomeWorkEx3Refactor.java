package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;


public class HomeWorkEx3Refactor extends CoreTestCase {

    @Test
    public void testSearchAndCancelSearch() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        SearchPageObject.waitForSearchResult("Island in Indonesia");
        SearchPageObject.clickCloseSearch();
        SearchPageObject.waitForCancelSearch();

    }
}
