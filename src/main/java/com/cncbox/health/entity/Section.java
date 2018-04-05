package com.cncbox.health.entity;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 栏目
 * Date: 2017/1/3
 * Time: 14:57
 */
public class Section {

    private int levelId;
    private int parentLevelId;
    private String levelName;
    private char levelType;


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

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public char getLevelType() {
        return levelType;
    }

    public void setLevelType(char levelType) {
        this.levelType = levelType;
    }
}
