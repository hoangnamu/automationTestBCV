package PageObject;

import Test.HelperClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PaymentTrackAwaitingAllAccountObject {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;
    HelperClass helperClass ;
    HashMap<String , Integer> allAccountHashMap;

    @AndroidFindBy(id = "android:id/content")
    private MobileElement centerViewContent;

    public PaymentTrackAwaitingAllAccountObject(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver,10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        helperClass = new HelperClass(driver);
        allAccountHashMap = new HashMap<>();
    }

    public boolean verifyAccountWithNumPayment(HashMap<String , Integer> inputHashMap) throws InterruptedException {
        boolean check = true;
        wait.until(ExpectedConditions.visibilityOf(centerViewContent));
        for(int i = 0;i<inputHashMap.size();i++){
            String ha = inputHashMap.keySet().toArray()[i].toString();
            System.out.println(ha);
            int verifyCount = numberOfPaymentsAccount(ha);
            System.out.println(verifyCount);
            int previousCount = inputHashMap.get(ha);
            if(verifyCount == previousCount){
                check = true;
            }else{
                check = false;
            }
            if(i == 1){
                helperClass.swipeForward(centerViewContent);
            }
        }
        return check;
    }

    public void test(String ha){
        System.out.println(numberOfPaymentsAccount(ha));
    }
    private int numberOfPaymentsAccount(String ha) {
        // do this function again
        // len ben tren 7 parent
        // 1 following sibling
        // kiem android.widget.RelativeLayout
        String xpath = "//android.widget.TextView[contains(@text,'"+ha+"')]/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/" +
                "following-sibling::*[1]/android.widget.RelativeLayout[contains(@resource-id,'payment_item')]";
        List<AndroidElement> count = driver.findElements(By.xpath(xpath));
        try {
            wait.until(helperClass.atLeastOneElementDisplayed(count));
        } catch (Exception e) {
            //e.printStackTrace();
        }
        if(count.isEmpty()){
            return 0;
        }
        else{
            return count.size();
        }
    }
}
