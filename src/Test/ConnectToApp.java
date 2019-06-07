package Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.CookieStore;
import java.net.MalformedURLException;
import java.net.URL;


public class ConnectToApp {


    public static void main(String[] args) throws Exception{

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6.0");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "ch.bcv.mobile.android.simulator");
        caps.setCapability("appActivity", "ch.bcv.mobile.android.activity.SplashActivity");

        caps.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);

    }

    public ConnectToApp(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6.0");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "ch.bcv.mobile.android.simulator");
        caps.setCapability("appActivity", "ch.bcv.mobile.android.activity.SplashActivity");
        caps.setCapability("autoGrantPermissions", true);
    }

}
