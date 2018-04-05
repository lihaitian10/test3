package com.cncbox.health.entity;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features:功能介绍
 * Date: 2017/1/6
 * Time: 9:46
 */
public class AnswerResult {

    private int answerId;
    private String answerContent;
    private int ranges;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

	public int getRanges() {
		return ranges;
	}

	public void setRanges(int ranges) {
		this.ranges = ranges;
	}

  
}
