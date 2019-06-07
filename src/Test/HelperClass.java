package Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
    AndroidDriver<AndroidElement> driver;
    protected static Logger log = Logger.getLogger(String.valueOf(HelperClass.class));
    private TakesScreenshot screenshot;
    WebDriverWait wait;

    public HelperClass(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver,10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public WebDriverWait getWait() {
        return wait;
    }
    public String convertIntMonthToText(int num){
        // quy doi thang so thanh chu
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num-1];
        }
        return month;
    }
    public String simpleMonth(String month){
        return month.substring(0,3);
    }

    public String formatDateFirstFormat(int day, int month , int year){
        //dd.mm.yyyy
        return day + "." +month+"."+year;
    }

    public String formatDateSecondFormat(int day , int month , int year){
        // dd May yyyy
//        return day +" " + simpleMonth(convertIntMonthToText(month))+" " + year;
        if(day<10){
            return "0"+day+" " + (convertIntMonthToText(month))+" " + year;
        }
        else
        {
            return day +" " + (convertIntMonthToText(month))+" " + year;
        }
    }

    public int convertMonthTextToMonthInt(String monthText){
        Date date = null;
        try {
            date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(monthText);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        return month;
    }
    public int firstDateGreaterSecondDateOrNot(int d1, int m1, int y1 , int d2, int m2, int y2){
        Calendar cal1 = Calendar.getInstance();
        cal1.set(y1,m1,d1);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(y2, m2 ,d2);
        if(cal1.compareTo(cal2) < 0){
            return -1;
        }
        else if (cal1.compareTo(cal2)>0){
            return 1;
        }
        else{
            return 0;
        }

    }
    public void logSteps(String description) {
        System.out.println(description);
//        log.info(description);
//        Reporter.log(description);
//        Reporter.log("<br/>");
    }

    public void takeScreenShoot(String fileName){
        // take screen shoot home screen:
        File scrFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:/temp/"+fileName+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    boolean greaterOrNot(int a, int b){
        if(a>b){
            return true;
        }
        else{
            return false;
        }
    }

    public ExpectedCondition<?> atLeastOneElementDisplayed(final List<AndroidElement> elements){
        return new ExpectedCondition<Object>(){
            @Override
            public Object apply(WebDriver webDriverInput) {
                List<AndroidElement> we = elements.stream().filter(p->p.isDisplayed()).collect(Collectors.toList());
                return (we.size()>0);
            }
        };
    }

    public ExpectedCondition<?> atLeastOneElementDisplayed(By by){
        return new ExpectedCondition<Object>() {
            @Override
            public Object apply(WebDriver webDriver) {
                return atLeastOneElementDisplayed(driver.findElements(by));
            }
        };
    }
    public void logBreakStep(){
        for(int i =0; i<50 ;i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void goBack(){
        logSteps("go back");
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    public void swipeForward(MobileElement centerView){
        wait.until(ExpectedConditions.visibilityOf(centerView));
        Point center = centerView.getCenter();
        logSteps("swipe forward");
        new TouchAction(driver).press(PointOption.point(center.x, center.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(center.x - 900, center.y - 900))
                .perform();
    }

    public void swipeBackward(MobileElement centerView){
        wait.until(ExpectedConditions.visibilityOf(centerView));
        Point center = centerView.getCenter();
        logSteps("swipe backward");

        new TouchAction(driver).press(PointOption.point(center.x, center.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(center.x - 900, center.y - 900))
                .perform();
    }
}
