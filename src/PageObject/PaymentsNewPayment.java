package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * choose new payment tag display this new payment page object:
 */
import java.util.List;

public class PaymentsNewPayment {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;

    public PaymentsNewPayment(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/beneficiary")
    private MobileElement newPaymentBeneficiaryBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/scan")
    private MobileElement newPaymentScanBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/a2a")
    private MobileElement newPamentTransferBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/manual")
    private MobileElement newPaymentNewBtn;

    // enter Ha number part:
    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_enter_data_edittext")
    private MobileElement enterHAEditText;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/header_button_right")
    private MobileElement continueBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_list_item_beneficiary_detail")
    private List<MobileElement> payment_list_item_beneficiary_detail;

    public void typeHANumber(String HAnum){
        wait.until(ExpectedConditions.visibilityOf(enterHAEditText));
        enterHAEditText.clear();
        enterHAEditText.sendKeys(HAnum);
    }

    /**
     * accept button has the same format:
     */
    public void clickContinueBtn(){
        wait.until(ExpectedConditions.visibilityOf(continueBtn));
        continueBtn.click();
    }

    public void clickNewBtn(){
        wait.until(ExpectedConditions.visibilityOf(newPaymentNewBtn));
        newPaymentNewBtn.click();
    }

    public void createNewPaymentManually(String HAnum){
        clickNewBtn();
        // HA number enter activity launched:
        typeHANumber(HAnum);
        clickContinueBtn();
    }

    /**
     * new payment display many account:
     * choose a account by input entry HA
     * @param entryHa
     */
    public void clickItemBeneficiaryDetail(String entryHa){
        for(int i=0;i<payment_list_item_beneficiary_detail.size();i++){
            wait.until(ExpectedConditions.visibilityOf(payment_list_item_beneficiary_detail.get(i)));
            if(payment_list_item_beneficiary_detail.get(i).getText().contains(entryHa)){
                payment_list_item_beneficiary_detail.get(i).click();
                break;
            }
        }
    }
}
