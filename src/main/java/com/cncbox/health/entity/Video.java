package com.cncbox.health.entity;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 视频内容
 * Date: 2017/1/3
 * Time: 16:22
 */
public class Video {

    private String vodName;
    private String firstLetter;
    private String image;
    private String rtspHd;
    private String rtspHd2;
    private String rtspHd3;
    private String localUid;
    private String entryType;
    private int vodId;
    private int levelId;
    private long timeLong;
    private char isCharged;

    public String getVodName() {
        return vodName;
    }

    public void setVodName(String vodName) {
        this.vodName = vodName;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRtspHd() {
        return rtspHd;
    }

    public void setRtspHd(String rtspHd) {
        this.rtspHd = rtspHd;
    }

    public String getRtspHd2() {
        return rtspHd2;
    }

    public void setRtspHd2(String rtspHd2) {
        this.rtspHd2 = rtspHd2;
    }

    public String getRtspHd3() {
        return rtspHd3;
    }

    public void setRtspHd3(String rtspHd3) {
        this.rtspHd3 = rtspHd3;
    }

    public String getLocalUid() {
        return localUid;
    }

    public void setLocalUid(String localUid) {
        this.localUid = localUid;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public int getVodId() {
        return vodId;
    }

    public void setVodId(int vodId) {
        this.vodId = vodId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public long getTimeLong() {
        return timeLong;
    }

    public void setTimeLong(long timeLong) {
        this.timeLong = timeLong;
    }

    public char getIsCharged() {
        return isCharged;
    }

    public void setIsCharged(char isCharged) {
        this.isCharged = isCharged;
    }
}
