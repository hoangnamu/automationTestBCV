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
import java.util.stream.Collectors;

public class PaymentsTrackPaymentsObject {
    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;

    public PaymentsTrackPaymentsObject(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver,10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/navigation_list_item_titel")
    private List<MobileElement> trackPaymentNavigationList;

    public void clickAwaitingSignature(){
        for(int i=0;i<trackPaymentNavigationList.size();i++){
            wait.until(ExpectedConditions.visibilityOf(trackPaymentNavigationList.get(i)));
            if(trackPaymentNavigationList.get(i).getText().contains("Awaiting")){
                trackPaymentNavigationList.get(i).click();
            }
        }
    }
    public void clickPaidOrPending(){
        for(int i=0;i<trackPaymentNavigationList.size();i++){
            wait.until(ExpectedConditions.visibilityOf(trackPaymentNavigationList.get(i)));
            if(trackPaymentNavigationList.get(i).getText().contains("paid")){
                trackPaymentNavigationList.get(i).click();
            }
        }
    }
    public void clickScheduled(){
        for(int i=0;i<trackPaymentNavigationList.size();i++){
            wait.until(ExpectedConditions.visibilityOf(trackPaymentNavigationList.get(i)));
            if(trackPaymentNavigationList.get(i).getText().contains("Scheduled")){
                trackPaymentNavigationList.get(i).click();
            }
        }
    }
    public void clickCanceled(){
        for(int i=0;i<trackPaymentNavigationList.size();i++){
            wait.until(ExpectedConditions.visibilityOf(trackPaymentNavigationList.get(i)));
            if(trackPaymentNavigationList.get(i).getText().contains("Canceled")){
                trackPaymentNavigationList.get(i).click();
            }
        }
    }
    public void clickStandingOrders(){
        for(int i=0;i<trackPaymentNavigationList.size();i++){
            wait.until(ExpectedConditions.visibilityOf(trackPaymentNavigationList.get(i)));
            if(trackPaymentNavigationList.get(i).getText().contains("standing")){
                trackPaymentNavigationList.get(i).click();
            }
        }
    }
}
