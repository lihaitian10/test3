package com.cncbox.health.entity;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 首页
 * Date: 2017/1/3
 * Time: 14:09
 */
public class Home {

    private int id;
    private int pckId;
    private String posiName;
    private String posiImage;
    private char posiAttr;
    private String actiUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPckId() {
        return pckId;
    }

    public void setPckId(int pckId) {
        this.pckId = pckId;
    }

    public String getPosiName() {
        return posiName;
    }

    public void setPosiName(String posiName) {
        this.posiName = posiName;
    }

    public String getPosiImage() {
        return posiImage;
    }

    public void setPosiImage(String posiImage) {
        this.posiImage = posiImage;
    }

    public char getPosiAttr() {
        return posiAttr;
    }

    public void setPosiAttr(char posiAttr) {
        this.posiAttr = posiAttr;
    }

    public String getActiUrl() {
        return actiUrl;
    }

    public void setActiUrl(String actiUrl) {
        this.actiUrl = actiUrl;
    }
}
