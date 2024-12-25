package src.tests;

import org.junit.Assert;
import src.lib.CoreTestCase;
import src.lib.Platform;
import src.lib.ui.ArticlePageObject;
import src.lib.ui.AuthorizationPageObject;
import src.lib.ui.SearchPageObject;
import src.lib.ui.factories.ArticlePageObjectFactory;
import src.lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase
{
    private static final String
    login = "hlynova",
    password = "12291987Artem!";


    @Test
    public void testSaveTwoArticlesDeleteOneArticle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        if ((Platform.getInstance().isAndroid()|| Platform.getInstance().isIOS())){
            SearchPageObject.initSkipButton();
        } else {
            return;
        }

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");
        if ((Platform.getInstance().isAndroid()|| Platform.getInstance().isIOS())){
            ArticlePageObject.waitElementPageSave();
        } else {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();

            Assert.assertEquals("We are not on the same page after login.", article_title, ArticlePageObject.getArticleTitle());

            ArticlePageObject.waitElementPageSave();
        }

        if (Platform.getInstance().isAndroid()){
            SearchPageObject.clickCancelSearch();
        } else if (Platform.getInstance().isIOS()){
            SearchPageObject.clickBackButton();
        } else {
            return;
        }
        SearchPageObject.clickCancelSearch();

        SearchPageObject.typeSearchLine("meme");
        SearchPageObject.clickByArticleWithSubstring("emento mori");
        ArticlePageObject.waitElementPageSave();
        if (Platform.getInstance().isAndroid()){
            SearchPageObject.clickCancelSearch();
        } else if (Platform.getInstance().isIOS()){
            SearchPageObject.clickBackButton();
        } else {
            return;
        }
        SearchPageObject.clickCancelSearch();

        SearchPageObject.openNavigation();
        SearchPageObject.waitNavigationBarSaveButton();
        if (Platform.getInstance().isIOS()) {
            SearchPageObject.clickCloseButton();
        } else if ((Platform.getInstance().isAndroid() || Platform.getInstance().isMW())) {
            return;
        }

        SearchPageObject.waitForArticleToAppearByTitle("bject-oriented programming language");
        SearchPageObject.waitForArticleToAppearByTitle("emento mori");
        SearchPageObject.swipeSaveArticleObject("bject-oriented programming language");
        SearchPageObject.waitForArticleToDisappearByTitle("bject-oriented programming language");
        SearchPageObject.waitForArticleToAppearByTitle("emento mori");

    }

    @Test
    public void testCompareArticleTitle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title = ArticlePageObject.getArticleTitle();


        assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title
        );
    }

    @Test
    public void testSwipeElementToLeft()
    {
        ArticlePageObject  ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.swipeToStartButton();

    }

    @Test
    public void testSaveArticle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        if ((Platform.getInstance().isAndroid()|| Platform.getInstance().isIOS())){
            SearchPageObject.initSkipButton();
        } else {
            return;
        }

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");
        if ((Platform.getInstance().isAndroid()|| Platform.getInstance().isIOS())){
            ArticlePageObject.waitElementPageSave();
        } else {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();

            assertEquals("We are not on the same page after login.",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );

            ArticlePageObject.waitElementPageSave();
        }

        if (Platform.getInstance().isAndroid()){
            SearchPageObject.clickCancelSearch();
        } else if (Platform.getInstance().isIOS()){
            SearchPageObject.clickBackButton();
        }
        SearchPageObject.clickCancelSearch();
        SearchPageObject.openNavigation();
        SearchPageObject.waitNavigationBarSaveButton();
        if (Platform.getInstance().isIOS()) {
            SearchPageObject.clickCloseButton();
        } else if (Platform.getInstance().isAndroid()) {
            return;
        }
        if ((Platform.getInstance().isAndroid()|| Platform.getInstance().isIOS())){
            SearchPageObject.waitSaveObject();
        } else {
            return;
        }

        SearchPageObject.swipeSaveObject();

    }
}
