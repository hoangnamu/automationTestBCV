package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject {

    private AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;

    // contructor:
    public HomePageObject(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //find all element in home screen:
    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/header_button_left")
    public MobileElement logoutBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/action_private_main")
    public MobileElement homeBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/action_private_account")
    public MobileElement accountBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/action_private_payment")
    public MobileElement paymentBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/action_private_ebill")
    public MobileElement ebillBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/action_private_more")
    public MobileElement moreBtn;

    //click action:
    public void clicklogoutBtn(){
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));
        logoutBtn.click();
    }
    public void clickhomeBtn(){
        wait.until(ExpectedConditions.visibilityOf(homeBtn));
        homeBtn.click();
    }
    public void clickaccountBtn(){
        wait.until(ExpectedConditions.visibilityOf(homeBtn));

    }
    public void clickpaymentBtn(){
        wait.until(ExpectedConditions.visibilityOf(paymentBtn));
        paymentBtn.click();
    }
    public void clickebillBtn(){
        wait.until(ExpectedConditions.visibilityOf(ebillBtn));
        ebillBtn.click();
    }
    public void clickmoreBtn(){
        wait.until(ExpectedConditions.visibilityOf(moreBtn));
        moreBtn.click();
    }

}
