package Test;

import PageObject.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;



public class NewPaymentTest {
    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "ch.bcv.mobile.android.simulator");
        caps.setCapability("appActivity", "ch.bcv.mobile.android.activity.SplashActivity");
        caps.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        driver.resetApp();
        TimeUnit.SECONDS.sleep(3);

        LoginPageObject loginObject = new LoginPageObject(driver);
        String userId = "HA005702";
        loginObject.login(userId);

        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.clickpaymentBtn();

        PaymentsPageObject paymentsPageObject = new PaymentsPageObject(driver);
        paymentsPageObject.clickNewPaymentsTab();

        PaymentsNewPayment paymentsNewPayment = new PaymentsNewPayment(driver);
        paymentsNewPayment.createNewPaymentManually("01-071534-6");

        PaymentsNewPaymentReviewPaymentPageObject paymentsNewPaymentReviewPaymentPageObject = new PaymentsNewPaymentReviewPaymentPageObject(driver);
        paymentsNewPaymentReviewPaymentPageObject.typeEeferenceNumberEditText("01 00011 70003 46160 01530 51000");
        paymentsNewPaymentReviewPaymentPageObject.typeAmountEditText("25.88");
        paymentsNewPaymentReviewPaymentPageObject.chooseDebitAccount("3845");
        paymentsNewPaymentReviewPaymentPageObject.typePersonalReference("test paiement bvr");
        paymentsNewPaymentReviewPaymentPageObject.typeAmountEditText("0.00");
        paymentsNewPaymentReviewPaymentPageObject.clickContinueBtn();
        paymentsNewPaymentReviewPaymentPageObject.typeAmountEditText("25.88");
        paymentsNewPaymentReviewPaymentPageObject.setDateCreateTo(30,5,2019);
        paymentsNewPaymentReviewPaymentPageObject.setDateCreateTo(5,6,2020);
        paymentsNewPaymentReviewPaymentPageObject.clickContinueBtn();
        paymentsNewPaymentReviewPaymentPageObject.clickAwaitingExcution();

        PaymentScheduledPageObject paymentScheduledPageObject = new PaymentScheduledPageObject(driver);
        paymentScheduledPageObject.clickScheduledPaymentAmount("25.88");
        driver.pressKeyCode(AndroidKeyCode.BACK);
        paymentScheduledPageObject.deleteScheduledPaymentWithAmount("25.88");

        homePageObject.clickpaymentBtn();
        paymentsPageObject.clickNewPaymentsTab();
        paymentsNewPayment.clickItemBeneficiaryDetail("010715346");
        TimeUnit.SECONDS.sleep(3);
        paymentsNewPaymentReviewPaymentPageObject.chooseDebitAccount("3846");
        paymentsNewPaymentReviewPaymentPageObject.clickContinueBtn();
        paymentsNewPaymentReviewPaymentPageObject.clickAwaitingExcution();

        PaymentSignaturePageObject paymentSignaturePageObject = new PaymentSignaturePageObject(driver);
        paymentSignaturePageObject.clickSignnatureWithAmount("25.88");
        driver.pressKeyCode(AndroidKeyCode.BACK);

        System.out.println("Done test");

        for(int i =0;i<10;++i){
            TimeUnit.SECONDS.sleep(60);
        }

    }
}


