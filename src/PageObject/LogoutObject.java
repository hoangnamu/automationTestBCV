package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutObject {
    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;

    public LogoutObject() {

    }
    public LogoutObject(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);

    }

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/header_button_left")
    private MobileElement logoutBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/secondary_button")
    private MobileElement closeAds;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement sayYesBtn;

    public void clickLogoutBtn(){
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));
        logoutBtn.click();
    }

    public void clickCloseAds(){
        wait.until(ExpectedConditions.visibilityOf(closeAds));
        closeAds.click();
    }
    public void clickYesBtn(){
        wait.until(ExpectedConditions.visibilityOf(sayYesBtn));
        sayYesBtn.click();
    }

    public void logOut(){
        clickLogoutBtn();
        clickYesBtn();
        clickCloseAds();
    }
}
