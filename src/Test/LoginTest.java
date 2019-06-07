package Test;

import PageObject.LoginPageObject;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static  void main(String[] args) throws Exception{

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "ch.bcv.mobile.android.simulator");
        caps.setCapability("appActivity", "ch.bcv.mobile.android.activity.SplashActivity");
        caps.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);

        driver.resetApp();
        HelperClass helperClass = new HelperClass(driver);

        helperClass.logSteps("Test case: login running ......");
        LoginPageObject loginObject = new LoginPageObject(driver);
        String userId = "HA005702";
        loginObject.login(userId);

        for(int i =0;i<10;++i){
            TimeUnit.SECONDS.sleep(60);
        }
    }
}
