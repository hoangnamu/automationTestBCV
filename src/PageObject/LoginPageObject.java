package PageObject;


import Test.HelperClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.bytebuddy.asm.Advice;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPageObject {

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;
    HelperClass helperClass ;

    public LoginPageObject() {

    }
    public LoginPageObject(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
        helperClass = new HelperClass(driver);
    }
    //finds all element need for login features
    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/accept_content_button_accept")
    public MobileElement acceptLicense;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/main_button")
    public MobileElement nextLicense;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/close")
    public MobileElement closeLicense;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/home_public_has_account")
    public MobileElement signInButton;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/login_contract_id")
    public MobileElement userIDEditText;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/login_contract_store_contract")
    public MobileElement rememberUserBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/header_button_right")
    public MobileElement continueBtn;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement sayYesBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/home_public_connect")
    private MobileElement home_public_connect;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/home_public_changeuser")
    private  MobileElement home_public_changeuser;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/login_multiuser_username")
    private List<AndroidElement> contractIdLayout;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/login_password")
    private MobileElement password;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/login_challenge_1")
    private MobileElement authentication;


    public void typeLoginAuthentication(){
        String id = "ch.bcv.mobile.android.simulator:id/login_challenge_";
        MobileElement inputNum;
        for(int i=1;i<=6;i++){
            String temp = id + i;
            try {
                wait.until(helperClass.atLeastOneElementDisplayed(By.id(temp)));
            } catch (Exception e) {
//                e.printStackTrace();
            }
            inputNum = driver.findElementById(temp);
            inputNum.click();
            inputNum.clear();
            inputNum.sendKeys(Integer.toString(i));
        }
    }
    public void typePassword(){
        wait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys("aaaaaa");
    }

    public void chooseLoginnedUserBefore(String ha){
        try {
            wait.until(helperClass.atLeastOneElementDisplayed(contractIdLayout));
        } catch (Exception e) {
//            e.printStackTrace();
        }
        if(!contractIdLayout.isEmpty()){
            for (int i=0;i<contractIdLayout.size();i++){
                if(contractIdLayout.get(i).getText().contains(ha)){
                    contractIdLayout.get(i).click();
                    break;
                }
            }
        }
    }

    public void chooseAnotherUser(){
        try {
            wait.until(helperClass.atLeastOneElementDisplayed(contractIdLayout));
        } catch (Exception e) {
//            e.printStackTrace();
        }
        if(!contractIdLayout.isEmpty()){
            for (int i=0;i<contractIdLayout.size();i++){
                if(contractIdLayout.get(i).getText().contains("Another")){
                    contractIdLayout.get(i).click();
                    break;
                }
            }
        }
    }
    public void clickLoginBtn(){
        wait.until(ExpectedConditions.visibilityOf(home_public_connect));
        home_public_connect.click();
    }
    public void clickChangeUserBtn(){
        wait.until(ExpectedConditions.visibilityOf(home_public_changeuser));
        home_public_changeuser.click();
    }

    public void clickAcceptLicense(){
        wait.until(ExpectedConditions.visibilityOf(acceptLicense));
        acceptLicense.click();
    }

    public void clickNextLicense(){
        wait.until(ExpectedConditions.visibilityOf(nextLicense));
        nextLicense.click();
    }

    public void clickCloseLicense(){
        wait.until(ExpectedConditions.visibilityOf(closeLicense));
        closeLicense.click();
    }

    public void clickSignInBtn(){
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public void clickUserIdEditText(){
        wait.until(ExpectedConditions.visibilityOf(userIDEditText));
        userIDEditText.click();
    }

    public void clickRememberUserBtn(){
        wait.until(ExpectedConditions.visibilityOf(rememberUserBtn));
        rememberUserBtn.click();
    }

    public void clickContinueBtn(){
        wait.until(ExpectedConditions.visibilityOf(continueBtn));
        continueBtn.click();
    }

    public void clickYesBtn(){
        wait.until(ExpectedConditions.visibilityOf(sayYesBtn));
        sayYesBtn.click();
    }

    public void clearEnterUserId(){
        wait.until(ExpectedConditions.visibilityOf(userIDEditText));
        if(userIDEditText.getText()!=""){
            userIDEditText.clear();
        }
    }

    public void typeUserId(String userId){
        wait.until(ExpectedConditions.visibilityOf(userIDEditText));
        if(userIDEditText.getText()==""){
            clickUserIdEditText();
            userIDEditText.sendKeys(userId);
        }
        else{ // if userid entered ==> clear ==> enter again
            clearEnterUserId();
            clickUserIdEditText();
            userIDEditText.sendKeys(userId);
        }
    }

    public void login(String userId){
        clickAcceptLicense();
        clickCloseLicense();
        clickSignInBtn();
        typeUserId(userId);
        clickContinueBtn();
        clickYesBtn();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void loginAfterLogout(String userID){
        clickChangeUserBtn();
        chooseAnotherUser();
        typeUserId(userID);
        clickContinueBtn();
        clickYesBtn();
        typePassword();
        clickContinueBtn();
    }
    public void loginHavePassword(String userID){
        clickAcceptLicense();
        clickCloseLicense();
        clickSignInBtn();
        typeUserId(userID);
        clickContinueBtn();
        clickYesBtn();
        typePassword();
        clickContinueBtn();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        typeLoginAuthentication();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
