package com.cncbox.health.entity;

/**
 * Created with IntelliJ IDEA.
 * User: 张立鹏(devep)
 * Features: 答题问题
 * Date: 2017/1/19
 * Time: 10:07
 */
public class AnswerProblem {

    private int quesId;
    private String quesContent;
    private int answer1;
    private String answerContent1;
    private int answer2;
    private String answerContent2;

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public String getQuesContent() {
        return quesContent;
    }

    public void setQuesContent(String quesContent) {
        this.quesContent = quesContent;
    }

    public int getAnswer1() {
        return answer1;
    }

    public void setAnswer1(int answer1) {
        this.answer1 = answer1;
    }

    public String getAnswerContent1() {
        return answerContent1;
    }

    public void setAnswerContent1(String answerContent1) {
        this.answerContent1 = answerContent1;
    }

    public int getAnswer2() {
        return answer2;
    }

    public void setAnswer2(int answer2) {
        this.answer2 = answer2;
    }

    public String getAnswerContent2() {
        return answerContent2;
    }

    public void setAnswerContent2(String answerContent2) {
        this.answerContent2 = answerContent2;
    }
}
