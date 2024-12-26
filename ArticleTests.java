package src.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.qameta.allure.junit4.Tags;
import org.junit.Assert;
import src.lib.CoreTestCase;
import src.lib.Platform;
import src.lib.ui.ArticlePageObject;
import src.lib.ui.AuthorizationPageObject;
import src.lib.ui.SearchPageObject;
import src.lib.ui.factories.ArticlePageObjectFactory;
import src.lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

@Epic("Tests for articles")
public class ArticleTests extends CoreTestCase
{
    private static final String
    login = "hlynova",
    password = "12291987Artem!";


    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @Tags(value = {@Tag(value = "Acceptance"), @Tag(value = "Regression")})
    @DisplayName("Compare article title with expected value")
    @Description("Open Wiki; Check search input; Enter search query and perform search; Check that article with description that corresponds expected is present on the search result page")
    @Step("Starting testCompareArticleTitle")
    @Severity(value = SeverityLevel.BLOCKER)
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

            Assert.assertEquals("We are not on the same page after login.", "article_title", ArticlePageObject.getArticleTitle());

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
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @Tags(value = {@Tag(value = "Regression")})
    @DisplayName("Swipe article to the footer")
    @Description("Open Wiki; Check search input; Enter search query and perform search; Click on the article title and open article page; Swipe/scroll article page until footer element becomes visible")
    @Step("Starting testSwipeArticle")
    @Severity(value = SeverityLevel.MINOR)
    public void testCompareArticleTitle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title = ArticlePageObject.getArticleTitle();


        Assert.assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title
        );
    }

    @Test
    @Features(value = {@Feature(value = "Onboarding"), @Feature(value = "Swipe")})
    @Tags(value = {@Tag(value = "Regression")})
    @DisplayName("Swipe onboarding")
    @Description("Open Wiki; Swipe onboarding pages")
    @Step("Starting testSwipeElementToLeft")
    @Severity(value = SeverityLevel.MINOR)
    public void testSwipeElementToLeft()
    {
        ArticlePageObject  ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.swipeToStartButton();

    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @Tags(value = {@Tag(value = "Regression")})
    @DisplayName("Swipe article to the footer")
    @Description("Open Wiki; Check search input; Enter search query and perform search; Click on the article title and open article page; Swipe/scroll article page until footer element becomes visible")
    @Step("Starting testSwipeArticle")
    @Severity(value = SeverityLevel.MINOR)
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

            Assert.assertEquals("We are not on the same page after login.",
                    "article_title",
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
