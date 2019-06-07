package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/** payment home screen contain :
 * new payment tag
 * track payment tag

 */
public class PaymentsPageObject {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;

    public PaymentsPageObject(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver,10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/tabsText")
    private List<MobileElement> paymentsTabsLayout;

    /**
     * choose track payment tag on payment home screen:
     */
    public void clickTrackPaymentsTab(){
        if(!paymentsTabsLayout.isEmpty()){
            for(int i =0;i<paymentsTabsLayout.size();i++){
                wait.until(ExpectedConditions.visibilityOf(paymentsTabsLayout.get(i)));
                if (paymentsTabsLayout.get(i).getText().contains("Track")) {
                    System.out.println(paymentsTabsLayout.get(i).getText());
                    paymentsTabsLayout.get(i).click();
                }
            }
        }
    }

    /**
     * choose new payment tag on payment home screen:
     */
    public void clickNewPaymentsTab(){
        if(!paymentsTabsLayout.isEmpty()){
            for(int i =0;i<paymentsTabsLayout.size();i++){
                wait.until(ExpectedConditions.visibilityOf(paymentsTabsLayout.get(i)));
                if (paymentsTabsLayout.get(i).getText().contains("New")) {
                    System.out.println(paymentsTabsLayout.get(i).getText());
                    paymentsTabsLayout.get(i).click();
                }
            }
        }
    }
}
