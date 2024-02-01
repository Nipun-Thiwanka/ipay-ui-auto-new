package utills;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUtils {

    private static final int DEFAULT_TIMEOUT = 10; // Default timeout in seconds

    /**
     * Wait for an element to be present in the DOM and displayed on the page.
     *
     * @param driver  AndroidDriver instance
     * @param locator By object identifying the element
     * @param timeout Maximum time to wait for the element to be present (in seconds)
     * @return WebElement representing the found element
     */
    public static WebElement waitForElement(AndroidDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for an element to be present in the DOM and displayed on the page with the default timeout.
     *
     * @param driver  AndroidDriver instance
     * @param locator By object identifying the element
     * @return WebElement representing the found element
     */
    public static WebElement waitForElement(AndroidDriver driver, By locator) {
        return waitForElement(driver, locator, DEFAULT_TIMEOUT);
    }

    /**
     * Check if an element is present in the DOM and displayed on the page.
     *
     * @param driver  AndroidDriver instance
     * @param locator By object identifying the element
     * @return true if the element is present and displayed, false otherwise
     */
    public static boolean isElementDisplayed(AndroidDriver driver, By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Take a screenshot and save it to a specified file path.
     *
     * @param driver AndroidDriver instance
     * @param filePath Path to save the screenshot
     */
    public static void takeScreenshot(AndroidDriver driver, String filePath) {
        // Add logic for taking a screenshot and saving it to the specified filePath
        // This can be done using driver.getScreenshotAs() method
    }
}