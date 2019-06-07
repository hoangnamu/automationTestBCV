package Test;

import PageObject.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestDIVEN_US01_executeDoneTest02 {

    private static final String LEONARD_HA = "HA005702";
    private static final String SHELDON_HA = "HA005703";
    private static final String PENNY_HA = "HA005704";
    private static final String ACCOUNT_B = "4585";
    private static final String ACCOUNT_C = "944";
    private static final String ACCOUNT_A = "4555";

    public static void LoginFunction(String ha, AndroidDriver driver, HelperClass helperClass, String step,String fileName){
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        helperClass.logSteps(step + ": ==================================================================");
        helperClass.logSteps(step+": Login Account " + ha);
        helperClass.logSteps("--> " + ha);
        loginPageObject.login(ha);
        helperClass.logSteps("--> take screen shoot " + fileName);
        helperClass.takeScreenShoot(fileName);
    }
    public static void LoginFunctionAfterLogOut(String ha, AndroidDriver driver, HelperClass helperClass, String step, String fileName){
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        helperClass.logSteps(step + ": ==================================================================");
        helperClass.logSteps(step+": Login Account " + ha);
        helperClass.logSteps("--> " + ha);
        loginPageObject.loginAfterLogout(ha);
        helperClass.logSteps("--> take screen shoot " + fileName);
        helperClass.takeScreenShoot(fileName);
    }
    public static void LoginFunctionHavePassword(String ha, AndroidDriver driver, HelperClass helperClass, String step, String fileName){
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        helperClass.logSteps(step + ": ==================================================================");
        helperClass.logSteps(step+": Login Account " + ha);
        helperClass.logSteps("--> " + ha);
        loginPageObject.loginHavePassword(ha);
        helperClass.logSteps("--> take screen shoot " + fileName);
        helperClass.takeScreenShoot(fileName);
    }

    public static void logOutFunction(AndroidDriver driver){
        LogoutObject logoutObject = new LogoutObject(driver);
        logoutObject.logOut();
    }

    public static void main(String[] args) throws Exception{

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "ch.bcv.mobile.android.simulator");
        caps.setCapability("appActivity", "ch.bcv.mobile.android.activity.SplashActivity");
        caps.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);

        driver.resetApp();

        HelperClass helperClass = new HelperClass(driver);

        helperClass.logSteps("Test case: TestDIVEN_US01_executeDoneTest02 ......");

        /**
         *      * Step 1: Login Account Leonard
         *      * Step 1.2: Open  Waiting for signature Page verify
         *      * Step 1.3: Click B account verify
         *      * Step 1.4: Click *4585* payment verify
         *      * Step 1.5: Delete payment *4585*
         *      * Step 1.6: Back to list account verify account B
         *      * Step 1.7: Click C account verify
         *      * Step 1.8: Delete payment *944*
         *      * Step 1.9: Back to list account  verify account C
         *      * Step 1.10: Click A account verify
         * * Step 2: Logout Account Leonard
         * * Step 3: Login Account Sheldon
         *      * Step 3.2: Open Waiting for signature Page verify
         *      * Step 3.3: Click B account verify
         *      * Step 3.4: Click *4585* payment verify
         *      * Step 3.5: Delete payment *4585*
         *      * Step 3.6: Back to list account verify account B
         *      * Step 3.7: Click C account verify
         *      * Step 3.8: Delete payment *944*  fail  verify failed page
         *      * Step 3.9: Back to list account  verify account C
         *      * Step 3.10: Click total account verify
         * * Step 4: Logout Account Sheldon
         * * Step 5: Login Account Penny
         *      * Step 5.2: Open Waiting for signature Page -> verify
         *      * Step 5.3: Click C account -> verify
         *      * Step 5.4: Delete payment *944*
         *      * Step 5.5: Back to list account  -> verify account C
         */

//        LoginFunction(LEONARD_HA, driver,helperClass, "Step 1", "logInToBCVNetWithSmartId_");

        HomePageObject homePageObject = new HomePageObject(driver);
        PaymentsTrackPaymentsObject paymentsTrackPaymentsObject = new PaymentsTrackPaymentsObject(driver);
        PaymentTrackPaymentAwaitingObject paymentTrackPaymentAwaitingObject = new PaymentTrackPaymentAwaitingObject(driver);
        PaymentSignaturePageObject paymentSignaturePageObject = new PaymentSignaturePageObject(driver);
        PaymentTrackAwaitingAllAccountObject paymentTrackAwaitingAllAccountObject = new PaymentTrackAwaitingAllAccountObject(driver);
        boolean check = true;

        helperClass.logBreakStep();
        helperClass.logSteps("Step 1.2: Open Waiting for signature Page verify");
        helperClass.logSteps("--> click payment button");
        homePageObject.clickpaymentBtn();
        helperClass.logSteps("--> click awaiting signature");
        paymentsTrackPaymentsObject.clickAwaitingSignature();
        helperClass.takeScreenShoot("Open_BCVnetSuiviPaiementsPage_Leonard");
        helperClass.logSteps("--> take screen shoot Open_BCVnetSuiviPaiementsPage_Leonard");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 1.3: Click B account verify");
        helperClass.logSteps("--> click account have number " + ACCOUNT_B);
        paymentTrackPaymentAwaitingObject.clickAccountWithNumber(ACCOUNT_B);
        /**
         * Verify number of
         * payments in B
         * equals to number
         * of payments in
         * account B show in
         * the previous  "En
         * attente de
         * signature" page
         */
        helperClass.logSteps("--> verify number of payments in B equal to number of payment in account B show in the previous :"
                +String.valueOf(paymentSignaturePageObject.getAccountNumber().contains(ACCOUNT_B)));
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt_02_Leonard_Open_Account_B");
        helperClass.takeScreenShoot("DIVEN_US01_dt_02_Leonard_Open_Account_B");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 1.4: Click *4585* payment verify");
        helperClass.logSteps("--> click payment" + ACCOUNT_B);
        paymentSignaturePageObject.clickPayment_item_beneficiaryContain(ACCOUNT_B);
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt_02_Leonard_Open_Payment_Account_B");
        helperClass.takeScreenShoot("DIVEN_US01_dt_02_Leonard_Open_Payment_Account_B");
        helperClass.goBack();

        helperClass.logBreakStep();
        helperClass.logSteps("Step 1.5: Delete payment *4585*");
        paymentSignaturePageObject.deletePaymentWithAccountNum(ACCOUNT_B);
        TimeUnit.SECONDS.sleep(2);
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Leonard_Delete_Payment_Account_B");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Leonard_Delete_Payment_Account_B");
        helperClass.goBack();

        helperClass.logBreakStep();
        helperClass.logSteps("Step 1.6: Back to list account verify account B");
        check = paymentTrackPaymentAwaitingObject.checkEmptyPaymentAccount(ACCOUNT_B);
        helperClass.logSteps("Verify account "+ACCOUNT_B+" is deleted in all payments in all accounts page: " + check);
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Leonard_Verify_Delete_Payment_B");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Leonard_Verify_Delete_Payment_B");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 1.7: Click C account verify");
        int numPayment = paymentTrackPaymentAwaitingObject.numberOfPaymentsAccount(ACCOUNT_C);
        helperClass.logSteps("--> count payment ACCOUNT_C has currently : " + numPayment);
        helperClass.logSteps("--> click account have number " + ACCOUNT_C);
        paymentTrackPaymentAwaitingObject.clickAccountWithNumber(ACCOUNT_C);
        int numSignature = paymentSignaturePageObject.countPaymentWithAccountNum(ACCOUNT_C);
        helperClass.logSteps("--> count number of signatures" + numSignature);
        if(numPayment == numSignature){
            helperClass.logSteps("--> verified SUCCESS");
        }else{
            helperClass.logSteps("--> verified FAIL");
        }
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Leonard_Open_Account_C");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Leonard_Open_Account_C");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 1.8: Delete payment *944*");
        helperClass.logSteps("--> delete payment in account : " + ACCOUNT_C);
        paymentSignaturePageObject.deletePaymentWithAccountNum(ACCOUNT_C);
        if(paymentSignaturePageObject.checkEmptySignatures(ACCOUNT_C)){
            helperClass.logSteps("--> delete payment in account : " + ACCOUNT_C + " empty ");
        }else{
            helperClass.logSteps("--> delete payment in account : " + ACCOUNT_C + " NOT empty ");
        }
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Leonard_Delete_Payment_Account_C");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Leonard_Delete_Payment_Account_C");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 1.9: Back to list account verify account C");
        helperClass.logSteps("--> go back ");
        helperClass.goBack();
        check = paymentTrackPaymentAwaitingObject.checkEmptyPaymentAccount(ACCOUNT_C);
        helperClass.logSteps("Verify account "+ACCOUNT_C+" is deleted in all payments in all accounts page: " + check);
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Leonard_Verify_Delete_Payment_C");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Leonard_Verify_Delete_Payment_C");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 1.10: Click A account verify");
         numPayment = paymentTrackPaymentAwaitingObject.numberOfPaymentsAccount(ACCOUNT_A);
        helperClass.logSteps("--> count payment ACCOUNT_A has currently : " + numPayment);
        helperClass.logSteps("--> click account have number " + ACCOUNT_A);
        paymentTrackPaymentAwaitingObject.clickAccountWithNumber(ACCOUNT_A);
         numSignature = paymentSignaturePageObject.countPaymentWithAccountNum(ACCOUNT_A);
        helperClass.logSteps("--> count number of signatures" + numSignature);
        if(numPayment == numSignature){
            helperClass.logSteps("--> verified SUCCESS");
        }else{
            helperClass.logSteps("--> verified FAIL");
        }
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Leonard_Open_Account_A");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Leonard_Open_Account_A");
        TimeUnit.SECONDS.sleep(10);
        helperClass.goBack();
        helperClass.goBack();

        helperClass.logSteps("Step 2: ==================================================================");
        helperClass.logSteps("--> logout user Leonard ");
        logOutFunction(driver);
        TimeUnit.SECONDS.sleep(4);
        helperClass.logSteps("--> take screen shoot Pre_Login_");
        helperClass.takeScreenShoot("Pre_Login_");

        LoginFunctionAfterLogOut(SHELDON_HA, driver, helperClass, "Step 3","logInBCVNetWithSMS_" );

        helperClass.logBreakStep();
        helperClass.logSteps("Step 3.2: Open Waiting for signature Page verify");
        helperClass.logSteps("--> homepage click payment");
        homePageObject.clickpaymentBtn();
        helperClass.logSteps("--> payment click awaiting payment");
        paymentsTrackPaymentsObject.clickAwaitingSignature();
        helperClass.logSteps("--> take screen shoot Open_BCVnetSuiviPaiementsPage_Sheldon");
        helperClass.takeScreenShoot("Open_BCVnetSuiviPaiementsPage_Sheldon");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 3.3: Click B account verify");
        helperClass.logSteps("--> click account have number " + ACCOUNT_B);
        paymentTrackPaymentAwaitingObject.clickAccountWithNumber(ACCOUNT_B);

        helperClass.logSteps("--> verify number of payments in B equal to number of payment in account B show in the previous :"
                +(paymentSignaturePageObject.getAccountNumber().contains(ACCOUNT_B)));
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Sheldon_Open_Account_B");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Sheldon_Open_Account_B");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 3.4: Click *4585* payment verify");
        helperClass.logSteps("--> click payment" + ACCOUNT_B);
        paymentSignaturePageObject.clickPayment_item_beneficiaryContain(ACCOUNT_B);
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Sheldon_Open_Payment_Account_B");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Sheldon_Open_Payment_Account_B");
        helperClass.goBack();

        helperClass.logBreakStep();
        helperClass.logSteps("Step 3.5: Delete payment *4585*");
        paymentSignaturePageObject.deletePaymentWithAccountNum(ACCOUNT_B);
        TimeUnit.SECONDS.sleep(2);
        helperClass.logSteps("Verify account is deleted in all payments in account B page :" + paymentSignaturePageObject.checkEmptySignatures(ACCOUNT_B));
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Sheldon_Delete_Payment_Account_B");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Sheldon_Delete_Payment_Account_B");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 3.6: Back to list account verify account B");
        helperClass.goBack();
         check = paymentTrackPaymentAwaitingObject.checkEmptyPaymentAccount(ACCOUNT_B);
        helperClass.logSteps("Verify account "+ACCOUNT_B+" is deleted in all payments in all accounts page: " + check);
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Sheldon_Verify_Delete_Payment_B");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Sheldon_Verify_Delete_Payment_B");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 3.7: Click C account verify");
         numPayment = paymentTrackPaymentAwaitingObject.numberOfPaymentsAccount(ACCOUNT_C);
        helperClass.logSteps("--> count payment ACCOUNT_C has currently : " + numPayment);
        helperClass.logSteps("--> click account have number " + ACCOUNT_C);
        paymentTrackPaymentAwaitingObject.clickAccountWithNumber(ACCOUNT_C);
         numSignature = paymentSignaturePageObject.countPaymentWithAccountNum(ACCOUNT_C);
        helperClass.logSteps("--> count number of signatures: " + numSignature);
        if(numPayment == numSignature){
            helperClass.logSteps("--> verified SUCCESS");
        }else{
            helperClass.logSteps("--> verified FAIL");
        }
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Sheldon_Open_Account_C");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Sheldon_Open_Account_C");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 3.8: Delete payment *944* fail verify failed page");
        paymentSignaturePageObject.signWithAccountNum(ACCOUNT_C);
        helperClass.logSteps("--> Verify payment is not fully signed: " + paymentSignaturePageObject.verifyAccountNotSigned());
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Sheldon_Sign_Payment_Account_C");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Sheldon_Sign_Payment_Account_C");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 3.9: Back to list account verify account C");
        helperClass.logSteps("--> go back ");
        helperClass.goBack();
        check = paymentTrackPaymentAwaitingObject.checkEmptyPaymentAccount(ACCOUNT_C);
        helperClass.logSteps("Verify account "+ACCOUNT_C+" is deleted in all payments in all accounts page: " + check);
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Sheldon_Verify_Sign_Payment_C");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Sheldon_Verify_Sign_Payment_C");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 3.10: Click total account verify");
        HashMap<String , Integer> awaitingHashMap = paymentTrackPaymentAwaitingObject.mapAccountWithNumOfPayments();
        System.out.println(awaitingHashMap);
        paymentTrackPaymentAwaitingObject.clickAllAccount();
        check = paymentTrackAwaitingAllAccountObject.verifyAccountWithNumPayment(awaitingHashMap);
        helperClass.logSteps("-->Verify number of payments in each account equals to number of payments in that account show in the previous :"+ check);

        helperClass.logSteps("Step 4: ==================================================================");
        helperClass.logSteps("Step 4: Logout Account Sheldon");
        helperClass.logSteps("--> logout user Sheldon ");
        logOutFunction(driver);
        TimeUnit.SECONDS.sleep(4);
        helperClass.logSteps("--> take screen shoot Pre_Login_");
        helperClass.takeScreenShoot("Pre_Login_");
        LoginFunctionAfterLogOut(PENNY_HA, driver,helperClass, "Step 5", "logInToBCVNetWithSmartId_");

        LoginFunction(PENNY_HA,driver, helperClass,"Step 5", "logInToBCVNetWithSmartId_");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 5.2: Open Waiting for signature Page verify");
        helperClass.logSteps("--> click payment button");
        homePageObject.clickpaymentBtn();
        helperClass.logSteps("--> click awaiting signature");
        paymentsTrackPaymentsObject.clickAwaitingSignature();
        helperClass.takeScreenShoot("Open_BCVnetSuiviPaiementsPage_Penny");
        helperClass.logSteps("--> take screen shoot Open_BCVnetSuiviPaiementsPage_Penny");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 5.3: Click B account verify");
        helperClass.logSteps("--> click account have number " + ACCOUNT_C);
        paymentTrackPaymentAwaitingObject.clickAccountWithNumber(ACCOUNT_C);
        helperClass.logSteps("--> verify number of payments in C equal to number of payment in account C show in the previous :"
                +(paymentSignaturePageObject.getAccountNumber().contains(ACCOUNT_C)));
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Penny_Open_Account_C");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Penny_Open_Account_C");

        helperClass.logBreakStep();
        helperClass.logSteps("Step 5.4: Step 5.4: Delete payment *944*");
        paymentSignaturePageObject.signWithAccountNum(ACCOUNT_C);
        check = paymentSignaturePageObject.checkEmptySignatures(ACCOUNT_C);
        helperClass.logSteps("--> verify account is signed in all payments in ACCOUNT_C page : "+ check);
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Penny_Sign_Payment_Account_C");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Penny_Sign_Payment_Account_C");

        helperClass.logSteps("Step 5.5: Back to list account  -> verify account C");
        helperClass.logSteps("--> go back");
        helperClass.goBack();

        check = paymentTrackPaymentAwaitingObject.checkEmptyPaymentAccount(ACCOUNT_C);
        helperClass.logSteps("Verify account "+ACCOUNT_C+" is signed in all payments in all accounts page: " + check);
        helperClass.logSteps("--> take screen shoot DIVEN_US01_dt02_Penny_Verify_Sign_Payment_C");
        helperClass.takeScreenShoot("DIVEN_US01_dt02_Penny_Verify_Sign_Payment_C");

        TimeUnit.SECONDS.sleep(60);
    }
}
