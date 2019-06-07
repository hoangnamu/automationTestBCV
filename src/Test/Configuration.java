package Test;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Configuration {

    private String deviceName = "";
    private String platformVersion ="";
    private String platformName ="";
    private String appPackage="";
    private String appActivity="";
    private String automationName ="";
    private boolean autoGrantPermissions = true;

    public Configuration(){

    }
    public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }
    public String getDeviceName(){
        return this.deviceName;
    }
    public void setPlatformVersion(String platformVersion){
        this.platformVersion = platformVersion;
    }
    public String getPlatformVersion(){
        return this.platformVersion;
    }
    public void setPlatformName(String platformName){
        this.platformName = platformName;
    }
    public String getPlatformName(){
        return this.platformName;
    }
    public void setAppPackage(String appPackage){
        this.appPackage = appPackage;
    }
    public String getAppPackage(){
        return this.appPackage;
    }
    public void setAppActivity(String appActivity){
        this.appActivity = appActivity;
    }
    public String getAppActivity(){
        return this.appActivity;
    }
    public void setAutomationName(String automationName){
        this.automationName = automationName;
    }
    public String getAutomationName(){
        return this.automationName;
    }
    public void setAutoGrantPermissions(boolean permissions){
        this.autoGrantPermissions = permissions;
    }

    public DesiredCapabilities initCapabilities(String platform){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(platform.contains(Platform.ANDROID.getPlatform())){
            capabilities.setCapability("deviceName", getDeviceName());
            capabilities.setCapability("platformName", platform);
            capabilities.setCapability("platformVersion",getPlatformVersion());
            capabilities.setCapability("appPackage",getAppPackage());
            capabilities.setCapability("appActivity",getAppActivity());
            capabilities.setCapability("automationName",getAutomationName());
        }
        else
        {
            // ios
        }
        return capabilities;
    }
}
