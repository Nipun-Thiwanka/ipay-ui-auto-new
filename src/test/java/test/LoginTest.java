package test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utills.CommonUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        // Set desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "R5CN20ZMB4L");
        capabilities.setCapability("kobiton:user", "ipaysl");
        capabilities.setCapability("kobiton:apiKey", "614ea42c-98ff-4a3f-9e2a-a5efb4475b16");
        // Add more capabilities as needed

        try {
            // Set the Appium server URL
            URL appiumServerURL = new URL("https://api.kobiton.com:443/wd/hub");

            // Initialize the AndroidDriver with WebElement
            driver = new AndroidDriver(appiumServerURL, capabilities);

            // Set implicit wait time
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoginButton() {
        // Find the login button by ID
        By loginButtonLocator = By.id("com.ipay.mobile:id/btnLogin");

        // Wait for the login button to be present and visible
        WebElement loginButton = CommonUtils.waitForElement(driver, loginButtonLocator);

        // Click on the login button
        loginButton.click();

        // Add assertions or further actions after clicking the login button
        // For example, you can check if the login screen is displayed or perform login actions
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
