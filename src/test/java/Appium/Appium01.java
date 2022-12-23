package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01 {

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();

        //capabilities.setCapability("platformName","Android");//Selenium'dan gelir
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");//Selenium'dan gelir

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");//Appium'dan gelir
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\LENOVO\\IdeaProjects\\AppiumTechpro\\src\\Apps\\gestureTool.apk");

        AndroidDriver<MobileElement> driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.findElementById("com.android.permissioncontroller:id/continue_button").click();



    }
}
