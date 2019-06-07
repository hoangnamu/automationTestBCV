package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MorePageObject {
    private AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;

    // contructor:
    public MorePageObject(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/itemDeposits")
    public MobileElement itemDeposits;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/itemCards")
    public  MobileElement itemCards;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/itemCredit")
    public MobileElement itemCredit;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/itemPFM")
    public MobileElement itemPFM;

    @AndroidFindBy(id ="ch.bcv.mobile.android.simulator:id/itemTwint" )
    public MobileElement itemTwint;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/itemPracticalInfo")
    public MobileElement itemPracticalInfo;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/itemSecureMail")
    public MobileElement itemSecureMail;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/itemEDocuments")
    public MobileElement itemEDocuments;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/itemBcvExtra")
    public  MobileElement itemBcvExtra;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/itemPreferences")
    public MobileElement itemPreferences;

    public void clickitemPreferences(){
        wait.until(ExpectedConditions.visibilityOf(itemPreferences));
        itemPreferences.click();
    }


}
