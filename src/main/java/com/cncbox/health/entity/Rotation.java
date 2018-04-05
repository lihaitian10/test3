package com.cncbox.health.entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 首页推荐位
 * Date: 2017/1/3
 * Time: 13:58
 */
public class Rotation {

    private String carousId;
    private char carousType;
    private String carousImg1;
    private String conId2;
    private String carousImg2;
    private String conId3;
    private String carousImg3;
    private String conId1;

    public String getCarousId() {
        return carousId;
    }

    public void setCarousId(String carousId) {
        this.carousId = carousId;
    }

    public char getCarousType() {
        return carousType;
    }

    public void setCarousType(char carousType) {
        this.carousType = carousType;
    }

    public String getCarousImg1() {
        return carousImg1;
    }

    public void setCarousImg1(String carousImg1) {
        this.carousImg1 = carousImg1;
    }

    public String getConId2() {
        return conId2;
    }

    public void setConId2(String conId2) {
        this.conId2 = conId2;
    }

    public String getCarousImg2() {
        return carousImg2;
    }

    public void setCarousImg2(String carousImg2) {
        this.carousImg2 = carousImg2;
    }

    public String getConId3() {
        return conId3;
    }

    public void setConId3(String conId3) {
        this.conId3 = conId3;
    }

    public String getCarousImg3() {
        return carousImg3;
    }

    public void setCarousImg3(String carousImg3) {
        this.carousImg3 = carousImg3;
    }

    public String getConId1() {
        return conId1;
    }

    public void setConId1(String conId1) {
        this.conId1 = conId1;
    }
}
