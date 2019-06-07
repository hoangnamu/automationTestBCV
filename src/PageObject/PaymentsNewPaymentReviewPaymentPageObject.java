package PageObject;

import Test.HelperClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PaymentsNewPaymentReviewPaymentPageObject {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;
    HelperClass helperClass = new HelperClass(driver);

    public PaymentsNewPaymentReviewPaymentPageObject(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_create_refnr")
    private MobileElement referenceNumberOption;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_enter_data_edittext")
    private MobileElement referenceNumberEditText;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/header_button_right")
    private MobileElement continueBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_create_amount")
    private MobileElement amountOption;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_enter_data_edittext")
    private MobileElement amountEditText;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_create_debitaccount")
    private MobileElement debitAccountOption;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/account_item_account_number")
    private List<MobileElement> listOfDebitAccount;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_create_personalreference")
    private MobileElement payment_create_personalreference;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_enter_data_edittext")
    private MobileElement payment_create_personalreferenceEditText;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_create_date_text")
    private MobileElement dateCreate;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/animator")
    private MobileElement calendarScrollView;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/date_picker_year")
    private MobileElement calendarPickerYear;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/date_picker_day")
    private MobileElement calendarPickerDay;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/date_picker_month")
    private MobileElement calendarPickerMonth;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/month_text_view")
    private List<MobileElement> calendarListOfYear;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/done_button")
    private MobileElement calendarDoneBtn;

    @AndroidFindBy(id = "ch.bcv.mobile.android.simulator:id/payment_sent_button_list")
    private MobileElement awaitingExcutionBtn;


    //enter reference number in review payment:
    public void clickReferenceNumber() {
        wait.until(ExpectedConditions.visibilityOf(referenceNumberOption));
        referenceNumberOption.click();
    }

    public void clickreferenceNumberEditText() {
        wait.until(ExpectedConditions.visibilityOf(referenceNumberEditText));
        referenceNumberEditText.click();
    }

    public void clickContinueBtn() {
        wait.until(ExpectedConditions.visibilityOf(continueBtn));
        continueBtn.click();
    }

    public void typeEeferenceNumberEditText(String reNum) {
        clickReferenceNumber();
        clickreferenceNumberEditText();
        referenceNumberEditText.clear();
        referenceNumberEditText.sendKeys(reNum);
        clickContinueBtn();
    }

    //enter amount:
    public void clickAmountOption() {
        wait.until(ExpectedConditions.visibilityOf(amountOption));
        amountOption.click();
    }

    public void clickAmountEditText() {
        wait.until(ExpectedConditions.visibilityOf(amountEditText));
        amountEditText.click();
    }

    public void typeAmountEditText(String amount) {
        clickAmountOption();
        clickAmountEditText();
        amountEditText.clear();
        amountEditText.sendKeys(amount);
        clickContinueBtn();
    }

    //select account:
    public void clickDebitAccountOption() {
        wait.until(ExpectedConditions.visibilityOf(debitAccountOption));
        debitAccountOption.click();
    }

    public void chooseDebitAccount(String accountNum) {
        clickDebitAccountOption();
        if (!listOfDebitAccount.isEmpty()) {
            for (int i = 0; i < listOfDebitAccount.size(); i++) {
                wait.until(ExpectedConditions.visibilityOf(listOfDebitAccount.get(i)));
                if (listOfDebitAccount.get(i).getText().contains(accountNum)) {
                    listOfDebitAccount.get(i).click();
                    break;
                }
            }
        }
    }
    //personal reference:
    public void clickPersonalReference() {
        wait.until(ExpectedConditions.visibilityOf(payment_create_personalreference));
        payment_create_personalreference.click();
    }

    public void typePersonalReference(String perRe) {
        clickPersonalReference();
        wait.until(ExpectedConditions.visibilityOf(payment_create_personalreferenceEditText));
        payment_create_personalreferenceEditText.clear();
        payment_create_personalreferenceEditText.sendKeys(perRe);
        clickContinueBtn();
    }

    // enter date create :
    public void swipeCalendarForward() {
        System.out.println("swipeCalendarForward : doing swipe forward");
        wait.until(ExpectedConditions.visibilityOf(calendarScrollView));
        Point center = calendarScrollView.getCenter();

        new TouchAction(driver).press(PointOption.point(center.x, center.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(center.x - 900, center.y - 900))
                .perform();
    }
    public void swipeCalendarBackward() {
        System.out.println("swipeCalendarBackward : doing swipe backward");
        wait.until(ExpectedConditions.visibilityOf(calendarScrollView));
        Point center = calendarScrollView.getCenter();

        new TouchAction(driver).press(PointOption.point(center.x, center.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(center.x + 900, center.y + 900))
                .perform();
    }
    public void clickCenterCalendar(){
        wait.until(ExpectedConditions.visibilityOf(calendarScrollView));
        Point center = calendarScrollView.getCenter();

    }
    public void clickDoneBtn(){
        wait.until(ExpectedConditions.visibilityOf(calendarDoneBtn));
        calendarDoneBtn.click();
    }
    /**
     * main part:
     * @param day
     * @param month
     * @param year
     */
    public void calendarSwipeToDate(int day, int month , int year){
        clickPaymentCreateDay();
        String toDateXPath = "//android.view.View[@content-desc=\"" + helperClass.formatDateSecondFormat(day, month, year) +"\"]";
        System.out.println("calendarSwipeToDate --> toDayXPath: " + toDateXPath);

        // set year first:
        wait.until(ExpectedConditions.visibilityOf(calendarPickerYear));
        clickCalendarYear();
        String toYear = Integer.toString(year);
        if(!calendarListOfYear.isEmpty()){
            for(int i=0;i<calendarListOfYear.size();i++){
                wait.until(ExpectedConditions.visibilityOf(calendarListOfYear.get(i)));
                if(calendarListOfYear.get(i).getText().contains(toYear)){
                    calendarListOfYear.get(i).click();
                    System.out.println("calendarSwipeToDate --> set year to: " + toYear);
                }
            }
        }
        //set Date
        wait.until(ExpectedConditions.visibilityOf(calendarPickerMonth));
        wait.until(ExpectedConditions.visibilityOf(calendarPickerDay));

        int pickedMonth = helperClass.convertMonthTextToMonthInt(calendarPickerMonth.getText())+1;
        int pickedDay = Integer.parseInt(calendarPickerDay.getText());
        int pickedYear = year;

        if(helperClass.firstDateGreaterSecondDateOrNot(pickedDay,pickedMonth,pickedYear, day,month,year) ==0){
            wait.until(ExpectedConditions.visibilityOf(continueBtn));
            clickContinueBtn();
        }
        else{
            /**
             * limit for prevent infinty loop:
             */
            if(helperClass.firstDateGreaterSecondDateOrNot(day, month,year, pickedDay,pickedMonth,pickedYear) == 1){
                System.out.println("calendarSwipeToDate --> swipe forward case ...");
                // input day greater than picked day on the screen: ==> swipe forward
                List<AndroidElement> possibleDay = driver.findElements(By.xpath(toDateXPath));
                if(!possibleDay.isEmpty()){
                    wait.until(ExpectedConditions.visibilityOf(possibleDay.get(0)));
                    possibleDay.get(0).click();
                } else{
                    int limit = 50;
                    while(possibleDay.isEmpty()&&limit >0){
                        swipeCalendarForward();
                        limit --;
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        possibleDay = driver.findElements(By.xpath(toDateXPath));
                        if(!possibleDay.isEmpty()){
                            wait.until(ExpectedConditions.visibilityOf(possibleDay.get(0)));
                            possibleDay.get(0).click();
                            break;
                        }
                    }
                }
                clickDoneBtn();
            }else if(helperClass.firstDateGreaterSecondDateOrNot(day, month,year, pickedDay,pickedMonth,pickedYear) == -1){
                // input day smaller than picked day on the screen: ==> swipe forward
                System.out.println("calendarSwipeToDate --> swipe backward case ...");
                // input day greater than picked day on the screen: ==> swipe forward
                List<AndroidElement> possibleDay = driver.findElements(By.xpath(toDateXPath));
                if(!possibleDay.isEmpty()) {
                    wait.until(ExpectedConditions.visibilityOf(possibleDay.get(0)));
                    possibleDay.get(0).click();
                }
                else{
                    int limit = 50;
                    while(possibleDay.isEmpty()&&limit >0){
                        swipeCalendarBackward();
                        limit--;
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        possibleDay = driver.findElements(By.xpath(toDateXPath));
                        if(!possibleDay.isEmpty()){
                            wait.until(ExpectedConditions.visibilityOf(possibleDay.get(0)));
                            possibleDay.get(0).click();
                            break;
                        }
                    }
                }
                clickDoneBtn();
            }else{
                // equal:
                // example: displayed date : 29/05/2019 , input date: 29/05/2020 ==> picked year then done
                System.out.println("calendarSwipeToDate : picked year then done");
                clickContinueBtn();
            }

        }
    }

    public void clickCalendarYear() {
        wait.until(ExpectedConditions.visibilityOf(calendarPickerYear));
        calendarPickerYear.click();
    }

    public void clickPaymentCreateDay() {
        wait.until(ExpectedConditions.visibilityOf(dateCreate));
        dateCreate.click();
    }
    public void setDateCreateTo(int day , int month , int year){
        if(!checkSameDateOrNot(day, month,year)){
            calendarSwipeToDate(day,month,year);
        }
    }

    /**
     * datecreate is day and month displayed on the screen:
     * @param day
     * @param month
     * @param year
     * @return
     */
    private boolean checkSameDateOrNot(int day, int month , int year) {
        wait.until(ExpectedConditions.visibilityOf(dateCreate));
        String pickedDate = dateCreate.getText();
        String cmpDate = helperClass.formatDateFirstFormat(day, month,year);
        System.out.println("compare ... " +pickedDate +" vs " + cmpDate);
        if(pickedDate.equals(cmpDate)){
            System.out.println("compare ... " +pickedDate +" vs " + cmpDate + " TRUE ");
            return true;
        }
        else{
            System.out.println("compare ... " +pickedDate +" vs " + cmpDate + " FALSE ");
            return false;
        }
    }
    //payment scheduled :
    public void clickAwaitingExcution(){
        wait.until(ExpectedConditions.visibilityOf(awaitingExcutionBtn));
        awaitingExcutionBtn.click();
    }
}
