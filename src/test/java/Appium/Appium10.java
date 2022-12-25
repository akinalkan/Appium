package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.ui.context.Theme;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium10 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\LENOVO\\IdeaProjects\\AppiumTechpro\\src\\Apps\\apiDemos.apk");
        // capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        // capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset", "true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
       //AndroidDriver driver= getAndroidDriver();
        System.out.println("App installed...");
        //api demos butonuna tikla
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(5000);
        //preference butonuna tikla
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(5000);
        //preference defendencies butonuna tikla
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        Thread.sleep(5000);
        //wifi checkbox tikla
        MobileElement wifiCheck = (MobileElement) driver.findElementById("android:id/checkbox");
        MobileElement wifiSettings = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']");
        if (wifiSettings.isEnabled()) {
            wifiSettings.click();
        } else {
            wifiCheck.click();
            wifiSettings.click();
        }
        MobileElement wifiTextBox = (MobileElement) driver.findElementById("android:id/edit");
        Thread.sleep(5000);
        wifiTextBox.sendKeys("text");
        Thread.sleep(5000);
        driver.findElementById("android:id/button1").click();


        //session kapat

        driver.closeApp();
    }
}
