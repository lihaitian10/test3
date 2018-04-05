package com.cncbox.health.entity;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 页数实体类
 * Date: 2017/1/4
 * Time: 9:06
 */
public class Page {

    //当前页
    private int thisPage;

    //总页数
    private int totalPages;

    //总记录数
    private int countNotes;

    //其他
    private String outhers;

    public int getThisPage() {
        return thisPage;
    }

    public void setThisPage(int thisPage) {
        this.thisPage = thisPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCountNotes() {
        return countNotes;
    }

    public void setCountNotes(int countNotes) {
        this.countNotes = countNotes;
    }

    public String getOuthers() {
        return outhers;
    }

    public void setOuthers(String outhers) {
        this.outhers = outhers;
    }
}
