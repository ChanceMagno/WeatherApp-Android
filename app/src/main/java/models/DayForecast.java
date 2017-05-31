package models;



public class DayForecast {
    private String mName;
    private String mMain;
    private String mDescription;
    private String mIcon;
    private String mCurrentTemp;
    private String mMaxTemp;
    private String mMinTemp;
    private String mCloudPercentage;

    public DayForecast(String mName, String mMain, String mDescription, String mIcon,
                       String mCurrentTemp, String mMaxTemp, String mMinTemp, String mCloudPercentage) {
        this.mName = mName;
        this.mMain = mMain;
        this.mDescription = mDescription;
        this.mIcon = mIcon;
        this.mCurrentTemp = mCurrentTemp;
        this.mMaxTemp = mMaxTemp;
        this.mMinTemp = mMinTemp;
        this.mCloudPercentage = mCloudPercentage;
    }

    public String getmName() {
        return mName;
    }

    public String getmMain() {
        return mMain;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmIcon() {
        return mIcon;
    }

    public String getmCurrentTemp() {
        return mCurrentTemp;
    }

    public String getmMaxTemp() {
        return mMaxTemp;
    }

    public String getmMinTemp() {
        return mMinTemp;
    }

    public String getmCloudPercentage() {
        return mCloudPercentage;
    }
}
