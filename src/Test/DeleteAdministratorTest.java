package Test;

import PageObject.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DeleteAdministratorTest {
    public static  void main(String[] args) throws Exception{

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");

//        caps.setCapability("app", "C:/Users/NEH/Documents/bcvnettablet-simulator-debug.apk");

        caps.setCapability("appPackage", "ch.bcv.mobile.android.simulator");
        caps.setCapability("appActivity", "ch.bcv.mobile.android.activity.SplashActivity");

        caps.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);

        driver.resetApp();
        // login :
        LoginPageObject loginObject = new LoginPageObject(driver);
        String userId = "HA005702";
        loginObject.login(userId);
        // delete:
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.clickmoreBtn();
        MorePageObject morePageObject = new MorePageObject(driver);
        morePageObject.clickitemPreferences();
        PreferencesPageObject preferencesPageObject = new PreferencesPageObject(driver);
        preferencesPageObject.clickBeneficiaries();
        BeneficiariesListPageObject beneficiariesListPageObject = new BeneficiariesListPageObject(driver);
        beneficiariesListPageObject.removeABeneficiary("ADMINISTRATION");

        driver.quit();
    }
}
