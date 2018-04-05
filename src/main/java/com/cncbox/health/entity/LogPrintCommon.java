package com.cncbox.health.entity;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 日志打印，与“log_health”表对应
 * Date: 2017/1/20
 * Time: 13:25
 */
public class LogPrintCommon {

    //组包id
    private int pckId;

    //名字
    private String conName;

    //资源id
    private int conId;

    //二级栏目id
    private int levelId;

    //一级栏目
    private int parentLevelId;

    //是否收费
    private char isFree;

    //媒资类型
    private char type;

    //页面编码
    private int pageCode;

    //操作状态
    private char statuz;

    //智能卡号
    private String smartCard;

    //客户端ip
    private String clientIp;

    //操作时间
    private long visitTime;

    //终端
    private char source;

    //区域码
    private String areaCode;

    public int getPckId() {
        return pckId;
    }

    public void setPckId(int pckId) {
        this.pckId = pckId;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public int getConId() {
        return conId;
    }

    public void setConId(int conId) {
        this.conId = conId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getParentLevelId() {
        return parentLevelId;
    }

    public void setParentLevelId(int parentLevelId) {
        this.parentLevelId = parentLevelId;
    }

    public char getIsFree() {
        return isFree;
    }

    public void setIsFree(char isFree) {
        this.isFree = isFree;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public char getStatuz() {
        return statuz;
    }

    public void setStatuz(char statuz) {
        this.statuz = statuz;
    }

    public String getSmartCard() {
        return smartCard;
    }

    public void setSmartCard(String smartCard) {
        this.smartCard = smartCard;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public long getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(long visitTime) {
        this.visitTime = visitTime;
    }

    public char getSource() {
        return source;
    }

    public void setSource(char source) {
        this.source = source;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
