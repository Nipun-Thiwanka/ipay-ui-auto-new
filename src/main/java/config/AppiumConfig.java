package config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class AppiumConfig {
    private static AndroidDriver driver;

    public static void configureDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set desired capabilities
        capabilities.setCapability("appium:UUID", "R5CN20ZMB4L");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "Galaxy S20+ 5G");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", "com.ipay.mobile");
        capabilities.setCapability("appium:appActivity", "com.ipay.mobile.v2.view.ActSplash");
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        capabilities.setCapability("appium:nativeWebScreenshot", true);
        capabilities.setCapability("kobiton:options", Map.ofEntries(Map.entry("source", "appiumdesktop")));
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);
        capabilities.setCapability("kobiton:user", "ipaysl");
        capabilities.setCapability("kobiton:apiKey", "614ea42c-98ff-4a3f-9e2a-a5efb4475b16");

        try {
            // Set the Appium server URL
            URL appiumServerURL = new URL("https://api.kobiton.com:443/wd/hub");

            // Initialize the AndroidDriver
            driver = new AndroidDriver(appiumServerURL, capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
