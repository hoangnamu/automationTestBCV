package Test;

public enum  Platform {
    ANDROID("android"), IOS("iOS");
    private String platform;

    Platform(String platform) {
        this.platform = platform;
    }

    public String getPlatform(){
        return platform;
    }

    public void setPlatform(String platform){
        this.platform = platform;
    }
}
