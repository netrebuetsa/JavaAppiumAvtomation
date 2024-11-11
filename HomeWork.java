import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class HomeWork {

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
    public void testCompareSearchTitle()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Skip')]"),
                "Cannot find button 'Skip'",
                5
        );


        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find Search Wikipedia",
                5
        );


        WebElement title_element = assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search title",
                5
        );

        String search_title = title_element.getAttribute("text");

        Assert.assertEquals(
                "We see unexpected title",
                "Search Wikipedia",
                search_title
        );
    }


    private WebElement assertElementHasText(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }


    private WebElement assertElementHasText(By by, String error_message)
    {
        return assertElementHasText(by, error_message, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = assertElementHasText(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }
    
}
