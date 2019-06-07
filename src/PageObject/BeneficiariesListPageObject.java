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


// list of beneficiaries screen:
public class BeneficiariesListPageObject {
    private AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;

    // contructor:
    public BeneficiariesListPageObject(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout")
    public MobileElement Administrator;

    // list of curremt Beneficiaries on the screen:
    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/settingsBeneficiariesNameTextView")
    private List<MobileElement> listOfBeneficiaries;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/action_private_more")
    private MobileElement moreBtn;

    public void clickAdministrator(){
        wait.until(ExpectedConditions.visibilityOf(Administrator));
        Administrator.click();
    }

    public void clickMoreBtn(){
        wait.until(ExpectedConditions.visibilityOf(moreBtn));
        moreBtn.click();
    }

    public void removeABeneficiary(String beneficiaryNameEntry){
        if(!listOfBeneficiaries.isEmpty()){
            String beneficiaryName ="";
            for(int i=0;i<listOfBeneficiaries.size();i++){
                // find that beneficiary with name
                beneficiaryName = listOfBeneficiaries.get(i).getText();
                if(beneficiaryName.contains(beneficiaryNameEntry)){
                    MobileElement beneficiaries = listOfBeneficiaries.get(i);
                    beneficiaries.click();
                    BeneficiariesPageObject beneficiariesPageObject = new BeneficiariesPageObject(this.driver);
                    beneficiariesPageObject.clickRemoveBeneficiaryBtn();
                    beneficiariesPageObject.clickYesPopupBtn();
                    moreBtn.click();
                }
            }
            return;
        }
        else{
            return;
        }

    }
}
