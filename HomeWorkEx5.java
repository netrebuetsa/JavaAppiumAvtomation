import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class HomeWorkEx5 {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:deviceName","and130");
        capabilities.setCapability("appium:platformVersion","13.0");
        capabilities.setCapability("appium:automationName","UiAutomator2");
        capabilities.setCapability("appium:appPackage","org.wikipedia");
        capabilities.setCapability("appium:appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/O.Hlynova/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/org.wikipedia_50492_apps.evozi.com.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);


    }

    @After
    public void tearDown()
    {
        driver.quit();

    }

    @Test
    public void swipeElementAndCheckTitle()
    {
        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/primaryTextView'][contains(@text, 'The Free Encyclopedia\n…in over 300 languages')]"),
                "Cannot find tittle on first page onboarding",
                5
        );

        scroll(200);

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/primaryTextView'][@text = 'New ways to explore']"),
                "Cannot find tittle on second page onboarding",
                5
        );

        scroll(200);

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/primaryTextView'][@text = 'Reading lists with sync']"),
                "Cannot find tittle on third page onboarding",
                5
        );

        scroll(200);

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/primaryTextView'][@text = 'Data & Privacy']"),
                "Cannot find tittle on fourth page onboarding",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_done_button"),
                "Cannot find done button",
                5
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/main_toolbar_wordmark"),
                "Cannot find done button",
                5
        );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }


    private WebElement waitForElementPresent(By by, String error_message)
    {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }


    public void scroll(int timeOfScroll)
    {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.80);
        int endX = (int) (size.width * 0.20);
        int centerY = size.height / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipe = new Sequence(finger,1)

                //Двигаем палец на начальную позицию
                .addAction(finger.createPointerMove(Duration.ofSeconds(0),
                        PointerInput.Origin.viewport(), startX, centerY))
                //Палец прикасается к экрану
                .addAction(finger.createPointerDown(0))

                //Палец двигается к конечной точке
                .addAction(finger.createPointerMove(Duration.ofMillis(timeOfScroll),
                        PointerInput.Origin.viewport(), endX, centerY))

                //Убираем палец с экрана
                .addAction(finger.createPointerUp(0));

        //Выполняем действия
        driver.perform(Arrays.asList(swipe));
    }

}
