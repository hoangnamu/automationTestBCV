package PageObject;

import Test.HelperClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.XpiDriverService;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class PaymentTrackPaymentAwaitingObject {
    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;
    HelperClass helperClass ;
    private HashMap<String , Integer> accountWithNum;

    public PaymentTrackPaymentAwaitingObject(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver,10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        helperClass = new HelperClass(driver);
        accountWithNum = new HashMap<String , Integer>();
    }

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/account_item_account_number")
    private List<AndroidElement> listOfAccount;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/allAccountsLayout")
    private MobileElement allAccount;

    public void clickAllAccount(){
//        String xpath = "android.widget.TextView[contains(@text, 'all')]";
//        List<AndroidElement> allAccount  = driver.findElements(By.xpath(xpath));
//        try {
//            wait.until(helperClass.atLeastOneElementDisplayed(allAccount));
//            allAccount.get(0).click();
//        } catch (Exception e) {
////            e.printStackTrace();
//        }
        wait.until(ExpectedConditions.visibilityOf(allAccount));
        allAccount.click();
    }

    public void clickAccountWithNumber(String num){
        for(int i=0;i<listOfAccount.size();i++){
            wait.until(ExpectedConditions.visibilityOf(listOfAccount.get(i)));
            if(listOfAccount.get(i).getText().contains(num)){
                listOfAccount.get(i).click();
            }
        }
    }
    public void clickAccountWithNumVerxpath(String num){
        String XPath = "//android.widget.TextView[contains(@text, '"+num+"')]";
        MobileElement clickAcc = driver.findElement(By.xpath(XPath));
        wait.until(ExpectedConditions.visibilityOf(clickAcc));
        clickAcc.click();
    }

    public boolean checkEmptyPaymentAccount(String account){
        String xpath = "//android.widget.TextView[contains(@text,'"+account+"')]/parent::*/parent::*/following-sibling::*/android.widget.TextView";
        List<AndroidElement> countPayment = driver.findElements(By.xpath(xpath));
        try {
            wait.until(helperClass.atLeastOneElementDisplayed(countPayment));
        } catch (Exception e) {
            //e.printStackTrace();
        }
        if(countPayment.isEmpty()){
            return true;
        }
        else{
            return false;
        }
//        try {
//            wait.until(helperClass.atLeastOneElementDisplayed(countPayment));
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }
    public int numberOfPaymentsAccount(String account) {
        if(!checkEmptyPaymentAccount(account)){
            String xpath = "//android.widget.TextView[contains(@text,'"+account+"')]/parent::*/parent::*/following-sibling::*/android.widget.TextView";
            List<AndroidElement> count = driver.findElements(By.xpath(xpath));
            try {
                wait.until(helperClass.atLeastOneElementDisplayed(count));
            } catch (Exception e) {
                //e.printStackTrace();
            }
            return Integer.parseInt(count.get(0).getText());
        }
        else{
            return 0;
        }
    }

    public HashMap<String, Integer> mapAccountWithNumOfPayments(){
        if(!listOfAccount.isEmpty()){
            try {
                wait.until(helperClass.atLeastOneElementDisplayed(listOfAccount));
            } catch (Exception e) {
//                e.printStackTrace();
            }
            for(int i=0;i<listOfAccount.size();i++){
                String tempString = listOfAccount.get(i).getText().substring(5,9);
                int count = numberOfPaymentsAccount(tempString);
                accountWithNum.put(tempString, count);
            }
        }
        return accountWithNum;
    }
}
