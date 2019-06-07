package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeneficiariesPageObject {

    private AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;

    public BeneficiariesPageObject(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver,10);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/header_text")
    private MobileElement beneficiariesTitle;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/beneficiaryName")
    private MobileElement beneficiaryName;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/beneficiaryAddressOne")
    private MobileElement beneficiaryAddressOne;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/beneficiaryAccountNumber")
    private MobileElement beneficiaryAccountNumber;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/beneficiaryAmount")
    private MobileElement beneficiaryAmount;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/settingsBeneficiaryDetailRemoveButton")
    private MobileElement removeBeneficiaryBtn;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement yesPopupBtn;

    @AndroidFindBy(id = "android:id/button2")
    private MobileElement noPopupBtn;

    public void clickRemoveBeneficiaryBtn(){
        wait.until(ExpectedConditions.visibilityOf(removeBeneficiaryBtn));
        removeBeneficiaryBtn.click();
    }

    public void clickYesPopupBtn(){
        wait.until(ExpectedConditions.visibilityOf(yesPopupBtn));
        yesPopupBtn.click();
    }

    public void clickNoPopupBtn(){
        wait.until(ExpectedConditions.visibilityOf(noPopupBtn));
        noPopupBtn.click();
    }

    String getBeneficiaryName(){
        wait.until(ExpectedConditions.visibilityOf(beneficiaryName));
        return beneficiaryName.getText();
    }


}
