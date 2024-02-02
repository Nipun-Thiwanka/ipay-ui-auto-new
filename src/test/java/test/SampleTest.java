package test;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {
     static AppiumDriver driver;
    public static void main(String[] args) {
        try {
            openIpay();
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    public static void openIpay() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "OPPO A17");
        cap.setCapability("udid", "ZS65HALFGINFGEPB");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12");

        cap.setCapability("appPackage", "com.ipay.mobile");
        cap.setCapability("appActivity", "com.ipay.mobile.v2.view.ActSplash");

        URL url = new URL(" http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, cap);
        System.out.println("Application Started....");
    }

}
