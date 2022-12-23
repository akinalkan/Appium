package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06NativeChrome {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");
        capabilities.setCapability("noReset", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.get("https://www.amazon.com");
        Thread.sleep(10000);
        System.out.println(driver.getContext() + "<====app acildigindaki tur");
        //burda aplikasyonun hangi turleri oldugunu gorem icin getContextHandles() kullaniyoruz.
//        Set<String> butunturler = driver.getContextHandles();
//        for (String tur: butunturler) {
//            System.out.println(tur);
//            if (tur.contains("WEBVIEW_chrome")) {
//                driver.context(tur);
//            }
//        }

        System.out.println(driver.getContext() + "<====degisimden sonraki tur");
        Thread.sleep(7000);
        MobileElement homeScreenLogo = driver.findElementByAccessibilityId("Amazon");
        Assert.assertTrue(homeScreenLogo.isDisplayed());
        System.out.println("Ana sayfadayiz");

        Thread.sleep(10000);

        MobileElement signInButton = driver.findElementByXPath("//android.view.View[@content-desc=\"your account\"]/android.widget.TextView");
        signInButton.click();
        Thread.sleep(10000);
        MobileElement wellcomeText=driver.findElementByAccessibilityId("Amazon");
        Assert.assertTrue(wellcomeText.isDisplayed());
        System.out.println("test bitti...");
        Thread.sleep(5000);
        //close session
        driver.closeApp();

    }
}
