package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentSignatureDetailObject {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;

    public PaymentSignatureDetailObject(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver,10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


}
