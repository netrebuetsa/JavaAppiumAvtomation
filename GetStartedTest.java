package src.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.qameta.allure.junit4.Tags;
import src.lib.CoreTestCase;
import src.lib.Platform;
import src.lib.ui.WelcomePageObject;
import org.junit.Test;

@Epic("Tests for onboarding")
public class GetStartedTest extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value = "Onboarding"), @Feature(value = "Swipe")})
    @Tags(value = {@Tag(value = "Regression")})
    @DisplayName("Swipe onboarding to start button")
    @Description("Open Wiki; Swipe onboarding pages to start button")
    @Step("Starting testPassTroughWelcome")
    @Severity(value = SeverityLevel.NORMAL)
    public void testPassTroughWelcome()
    {
        if ((Platform.getInstance().isMW() || Platform.getInstance().isAndroid())) {
            return;
        }
        WelcomePageObject WelcomePageObject = new  WelcomePageObject(driver);

        WelcomePageObject.waitForLearnMoreLink();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForNewWayToExploreText();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForAddOrEditPreferredLangText();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForALearnMoreAboutDataCollectedText();
        WelcomePageObject.clickGetStartedButton();
    }

}
