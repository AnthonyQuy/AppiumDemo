package common;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected MobileDriver<AndroidElement> driver = null;

    public void waitForSeconds(int s) {
        driver.manage().timeouts().implicitlyWait(s, TimeUnit.SECONDS);
    }

    protected AndroidElement getElement(By by) {
        return driver.findElement(by);
    }

    public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "5.5.0");
        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.anthonyquy.masoi");
        capabilities.setCapability("appActivity", "com.anthonyquy.masoi.MainActivity");
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
