package model;

public class Single {

    public String mId;
    public String mBusNo;
    public String mLatSource;
    public String mLonSource;
    public String mTimeSource;
    public String mLatDest;
    public String mLonDest;
    public String mTimeDest;
    public String mSingleDistance;
    public String mSingleTime;
    public String mSingleCollection;
    public int mSingleTickets;
    public String mSingleExpenses;
    public String mSingleRFIDCollection;
    public boolean mIsActive;
    public boolean mIsToday;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getBusNo() {
        return mBusNo;
    }

    public void setBusNo(String busNo) {
        this.mBusNo = busNo;
    }

    public String getLatSource() {
        return mLatSource;
    }

    public void setLatSource(String latSource) {
        this.mLatSource = latSource;
    }

    public String getLonSource() {
        return mLonSource;
    }

    public void setLonSource(String lonSource) {
        this.mLonSource = lonSource;
    }

    public String getTimeSource() {
        return mTimeSource;
    }

    public void setTimeSource(String timeSource) {
        this.mTimeSource = timeSource;
    }

    public String getLatDest() {
        return mLatDest;
    }

    public void setLatDest(String latDest) {
        this.mLatDest = latDest;
    }

    public String getLonDest() {
        return mLonDest;
    }

    public void setLonDest(String lonDest) {
        this.mLonDest = lonDest;
    }

    public String getTimeDest() {
        return mTimeDest;
    }

    public void setTimeDest(String timeDest) {
        this.mTimeDest = timeDest;
    }

    public String getSingleDistance() {
        return mSingleDistance;
    }

    public void setSingleDistance(String singleDistance) {
        this.mSingleDistance = singleDistance;
    }

    public String getSingleTime() {
        return mSingleTime;
    }

    public void setSingleTime(String singleTime) {
        this.mSingleTime = singleTime;
    }

    public String getSingleCollection() {
        return mSingleCollection;
    }

    public void setSingleCollection(String singleCollection) {
        this.mSingleCollection = singleCollection;
    }

    public int getSingleTickets() {
        return mSingleTickets;
    }

    public void setSingleTickets(int singleTickets) {
        this.mSingleTickets = singleTickets;
    }

    public String getSingleExpenses() {
        return mSingleExpenses;
    }

    public void setSingleExpenses(String singleExpenses) {
        this.mSingleExpenses = singleExpenses;
    }

    public String getSingleRFIDCollection() {
        return mSingleRFIDCollection;
    }

    public void setSingleRFIDCollection(String singleRFIDCollection) {
        this.mSingleRFIDCollection = singleRFIDCollection;
    }

    public boolean getIsActive() {
        return mIsActive;
    }

    public void setIsActive(boolean isActive) {
        this.mIsActive = isActive;
    }

    public boolean getIsToday() {
        return mIsToday;
    }

    public void setIsToday(boolean isToday) {
        this.mIsToday = isToday;
    }
}
