package src.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.lib.Platform;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }


    public WebElement waitForElementPresent(String locator, String error_message) {
        return waitForElementPresent(locator, error_message, 5);
    }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }


    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public void scroll(int timeOfScroll) {

        if (driver instanceof AppiumDriver) {
            Dimension size = driver.manage().window().getSize();
            int startX = (int) (size.width * 0.80);
            int endX = (int) (size.width * 0.20);
            int centerY = size.height / 2;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1)

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
        } else {
            System.out.println("Method rotateScreenLandscape() does nothing fpr platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void scrollToLeft() {

        if (driver instanceof AppiumDriver) {
            scroll(200);
        } else {
            System.out.println("Method rotateScreenLandscape() does nothing fpr platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void scrollToLeftFindElement(String locator, String error_message, int max_scrolls) {

        if (driver instanceof AppiumDriver) {
            By by = this.getLocatorByString(locator);
            int already_scrolls = 0;
            while (driver.findElements(by).size() == 0) {

                if (already_scrolls > max_scrolls) {
                    waitForElementPresent(locator, "Cannot find element by scrolling to left. \n" + error_message, 0);
                    return;
                }

                scrollToLeft();
                ++already_scrolls;
            }
        } else {
            System.out.println("Method rotateScreenLandscape() does nothing fpr platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementNotPresent(String locator, String error_message) {
        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements > 0) {
            String default_message = "An element '" + locator + "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }

    public void assertElementPresent(String locator, String error_message) {
        By by = this.getLocatorByString(locator);
        int amount_of_title = getAmountOfElements(locator);

        if (amount_of_title == 0) {
            String default_message = "Element '" + locator + "' supposed to be present;";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public void swipeElementToLeft(String locator, String error_message) {

        if (driver instanceof AppiumDriver) {

            By by = this.getLocatorByString(locator);
            // Находим элемент на экране, ожидая его появления в течение 10 секунд.
            WebElement element = waitForElementPresent(locator, error_message, 10);

            // Получаем координаты элемента на экране.
            Point location = element.getLocation();
            // Получаем размеры элемента (ширину и высоту).
            Dimension size = element.getSize();

            // Координата по оси X левой границы элемента.
            int left_x = location.getX();
            // Координата по оси X правой границы элемента.
            int right_x = left_x + size.getWidth();
            // Координата по оси Y верхней границы элемента.
            int upper_y = location.getY();
            // Координата по оси Y нижней границы элемента.
            int lower_y = upper_y + size.getHeight();
            // Координата по оси Y средней линии элемента.
            int middle_y = upper_y + (size.getHeight() / 2);

            // Начальная координата по оси X для свайпа (чуть левее правого края элемента).
            int start_x = right_x - 30;
            // Конечная координата по оси X для свайпа (чуть правее левого края элемента).
            int end_x = left_x + 250;
            // Начальная координата по оси Y для свайпа (по центру элемента).
            int start_y = middle_y;
            // Конечная координата по оси Y для свайпа (также по центру элемента).
            int end_y = middle_y;

            // Выполняем свайп с начальной точки до конечной с заданной продолжительностью.
            this.swipe(
                    new Point(start_x, start_y),
                    new Point(end_x, end_y),
                    Duration.ofMillis(550)  // Устанавливаем продолжительность свайпа 550 миллисекунд.
            );
        } else {
            System.out.println("Method rotateScreenLandscape() does nothing fpr platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void swipe(Point start, Point end, Duration duration) {

        if (driver instanceof AppiumDriver) {

            // Создаем объект, представляющий палец для выполнения свайпа.
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            // Создаем последовательность действий для выполнения свайпа.
            Sequence swipe = new Sequence(finger, 1);

            // Добавляем действие для перемещения пальца к начальной точке.
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
            // Добавляем действие для нажатия на экран в начальной точке.
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            // Добавляем действие для перемещения пальца из начальной точки в конечную в течение заданного времени.
            swipe.addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
            // Добавляем действие для отпускания пальца от экрана в конечной точке.
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            // Выполняем последовательность действий (свайп).
            this.driver.perform(Arrays.asList(swipe));
        } else {
            System.out.println("Method rotateScreenLandscape() does nothing fpr platform " + Platform.getInstance().getPlatformVar());
        }
        }

        private By getLocatorByString (String locator_with_type){
            String[] exploted_locator = locator_with_type.split(Pattern.quote(":"), 2);
            String by_type = exploted_locator[0];
            String locator = exploted_locator[1];

            if (by_type.equals("xpath")) {
                return By.xpath(locator);
            } else if (by_type.equals("id")) {
                return By.id(locator);
            } else if (by_type.equals("css")) {
                return By.cssSelector(locator);
            }
            else {
                throw new IllegalArgumentException("Cannot get type of locator. Locator: " + locator);
            }

        }

        public void scrollWebPageUp() {
        if (Platform.getInstance().isMW()) {
            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
            JSExecutor.executeScript("window.scrollBy(0, 250)");
        } else {
            System.out.println("Method scrollWebPageUp() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
        }

        public void scrollWebPageTillElementNotVisible(String locator, String error_message, int max_swipes) {
        int already_swiped = 0;

        WebElement element = this.waitForElementPresent(locator, error_message);

        while (!this.isElementLocatedOnTheScreen(locator)) {
            scrollWebPageUp();
            ++already_swiped;
            if (already_swiped > max_swipes) {
                Assert.assertTrue(error_message, element.isDisplayed());
            }
        }
        }

        public boolean isElementLocatedOnTheScreen(String locator)
        {
            int element_location_by_y = this.waitForElementPresent(locator, "Cannot find element by locator", 1).getLocation().getY();
           if (Platform.getInstance().isMW()) {
               JavascriptExecutor JSExecutor = (JavascriptExecutor)driver;
               Object js_result = JSExecutor.executeScript("return window.pageYOffset");
               element_location_by_y -= Integer.parseInt(js_result.toString());
           }

            int screen_size_by_y = driver.manage().window().getSize().getHeight();
            return element_location_by_y < screen_size_by_y;

        }

        public boolean isElementPresent(String locator)
        {
            return getAmountOfElements(locator) > 0;
        }

        public void tryClickElementWithFewAttempts(String locator, String error_message, int amount_of_attempts) {
            int current_attempts = 0;
            boolean need_more_attempts = true;

            while (need_more_attempts) {
                try {
                    this.waitForElementAndClick(locator, error_message, 1);
                    need_more_attempts = false;
                } catch (Exception e) {
                    if (current_attempts > amount_of_attempts) {
                        this.waitForElementAndClick(locator, error_message, 1);
                    }
                }
                ++ current_attempts;
            }
        }



}
