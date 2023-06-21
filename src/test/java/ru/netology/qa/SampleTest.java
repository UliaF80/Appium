package ru.netology.qa;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "myPhone");
        desiredCapabilities.setCapability("appium:appPackege", "com.google.android.calculator");
        desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_5_s");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_minus_s");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_3_s");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_equal_s");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.miui.calculator:id/result");
        el5.isDisplayed();
        Assertions.assertEquals("= 2", el5.getText());

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

