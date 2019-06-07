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

public class PaymentScheduledPageObject {
    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;
    HelperClass helperClass = new HelperClass(driver);

    public PaymentScheduledPageObject(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_item_amount")
    private List<MobileElement> listOfScheduledPayments;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/header_button_left")
    private MobileElement scheduledPaymentDeleteBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_item_delete_button")
    private List<MobileElement> listOfDeleteBtn;

    @AndroidFindBy(id="android:id/button1")
    private MobileElement yesBtn;

    @AndroidFindBy(id = "android:id/button2")
    private MobileElement noBtn;

    public void clickScheduledPaymentAmount(String amount){
        if(!listOfScheduledPayments.isEmpty()){
            for(int i=0;i<listOfScheduledPayments.size();++i){
                wait.until(ExpectedConditions.visibilityOf(listOfScheduledPayments.get(i)));
                if(listOfScheduledPayments.get(i).getText().contains(amount)){
                    listOfScheduledPayments.get(i).click();
                    break;
                }
            }
        }
    }
    public void clickYesBtn(){
        wait.until(ExpectedConditions.visibilityOf(yesBtn));
        yesBtn.click();
    }
    public void clickNoBtn(){
        wait.until(ExpectedConditions.visibilityOf(noBtn));
        noBtn.click();
    }
    public void clickScheduledPaymentDeleteBtn(){
        wait.until(ExpectedConditions.visibilityOf(scheduledPaymentDeleteBtn));
        scheduledPaymentDeleteBtn.click();
    }

    public void deleteScheduledPaymentWithAmount(String amount){
        clickScheduledPaymentDeleteBtn();

        String xpath = "//android.widget.TextView[contains(@text, '"+amount+"')]/parent::*/parent::*/preceding-sibling::*";

        MobileElement deleteone = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(deleteone));
        deleteone.click();

        clickYesBtn();
    }
}
