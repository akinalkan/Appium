package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium14browserstackCalculator {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "akinalkan_Ag48b9");
        caps.setCapability("browserstack.key", "zkSfF1cCFxMfQbMMsmpM");

        // Set URL of the application under test
        caps.setCapability("app", "bs://bec21e578fff84c5c994972f240a38e0f67e07da");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Kendi aplikasyonumuz");
        caps.setCapability("build", "yeni");
        caps.setCapability("name", "hesap makinasi");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);
Thread.sleep(10000);
        // Write your test case statements here

        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        Thread.sleep(5000);

        driver.findElementByAccessibilityId("plus").click();
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        Thread.sleep(3000);

        driver.findElementByAccessibilityId("equals").click();
        Thread.sleep(10000);

        Assert.assertEquals(driver.findElementById("com.google.android.calculator:id/result_final").getText(),"10");

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();


    }

}
