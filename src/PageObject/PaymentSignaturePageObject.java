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

import java.util.List;

public class PaymentSignaturePageObject {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;
    HelperClass helperClass;

    public PaymentSignaturePageObject(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        helperClass = new HelperClass(driver);
    }

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_item_amount")
    private List<MobileElement> listSignatures;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/account_item_account_number")
    private MobileElement accountNumber;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_item_beneficiary")
    private List<MobileElement> payment_item_beneficiary;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/header_button_left")
    private MobileElement topLeftBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/awaiting_payments_sign_delete")
    private MobileElement deleteBtn;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement yesBtn;
    @AndroidFindBy(id = "android:id/button2")
    private MobileElement noBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/awaiting_payments_sign_sign")
    private MobileElement signBtn;

    public boolean verifyAccountNotSigned(){
        boolean check = false;
        try {
            wait.until(helperClass.atLeastOneElementDisplayed(By.id("ch.bcv.mobile.android.simulator:id/error_message")));
            check = true;
            helperClass.goBack();
        } catch (Exception e) {
//            e.printStackTrace();
            check = false;
        }
        return check;
    }
    public void clickSignBtn(){
        wait.until(ExpectedConditions.visibilityOf(signBtn));
        signBtn.click();
    }
    public void signWithAccountNum(String account){
        clickTopLeftBtn();
        String XPath = "//android.widget.TextView[contains(@text, '"+account+"')]/parent::*/preceding-sibling::*";
        MobileElement checkAccount = driver.findElement(By.xpath(XPath));
        wait.until(ExpectedConditions.visibilityOf(checkAccount));
        checkAccount.click();
        clickSignBtn();
        clickYesBtn();
    }

    public void clickSignnatureWithAmount(String amount){
        for(int i=0;i<listSignatures.size();i++){
            wait.until(ExpectedConditions.visibilityOf(listSignatures.get(i)));
            if(listSignatures.get(i).getText().contains(amount)){
                listSignatures.get(i).click();
                break;
            }
        }
    }
    public int countPaymentWithAccountNum(String num){
        int count =0;
        for(int i=0;i<listSignatures.size();i++){
            wait.until(ExpectedConditions.visibilityOf(listSignatures.get(i)));
            count++;
        }
        return count;
    }

    public String getAccountNumber(){
        wait.until(ExpectedConditions.visibilityOf(accountNumber));
        return accountNumber.getText();
    }

    public void clickPayment_item_beneficiaryContain(String entry){
        for(int i=0;i<payment_item_beneficiary.size();i++){
            wait.until(ExpectedConditions.visibilityOf(payment_item_beneficiary.get(i)));
            if(payment_item_beneficiary.get(i).getText().contains(entry)){
                payment_item_beneficiary.get(i).click();
                break;
            }
        }
    }
    public void clickTopLeftBtn(){
        wait.until(ExpectedConditions.visibilityOf(topLeftBtn));
        topLeftBtn.click();
    }
    public void clickDeleteBtn(){
        wait.until(ExpectedConditions.visibilityOf(deleteBtn));
        deleteBtn.click();
    }
    public void clickYesBtn(){
        wait.until(ExpectedConditions.visibilityOf(yesBtn));
        yesBtn.click();
    }
    public void clickNoBtn(){
        wait.until(ExpectedConditions.visibilityOf(noBtn));
        noBtn.click();
    }
    public void deletePaymentWithAccountNum(String num){
        clickTopLeftBtn();
        String XPath = "//android.widget.TextView[contains(@text, '"+num+"')]/parent::*/preceding-sibling::*";
        MobileElement checkAccount = driver.findElement(By.xpath(XPath));
        wait.until(ExpectedConditions.visibilityOf(checkAccount));
        checkAccount.click();
        clickDeleteBtn();
        clickYesBtn();
    }
    public boolean checkEmptySignatures(String account){
        if(countPaymentWithAccountNum(account)== 0){
            return true;
        }
        else{
            return false;
        }
    }

}