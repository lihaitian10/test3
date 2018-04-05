package com.cncbox.health.entity;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 文章
 * Date: 2017/1/4
 * Time: 14:40
 */
public class Article {

    private int infoId;
    private int levelId;
    private String infoName;
    private String firstLetter;
    private String image;
    private String infoImage;
    private String infoContent;
    private char isCharged;

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
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

    public String getInfoImage() {
        return infoImage;
    }

    public void setInfoImage(String infoImage) {
        this.infoImage = infoImage;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public char getIsCharged() {
        return isCharged;
    }

    public void setIsCharged(char isCharged) {
        this.isCharged = isCharged;
    }
}
