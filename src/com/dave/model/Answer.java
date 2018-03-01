package com.dave.model;

public class Answer {
    private int answerId;
    private String description;
    private int questionIdFk;
    private Question question;

    public Answer(int answerId, String description, int questionIdFk) {
        this.answerId = answerId;
        this.description = description;
        this.questionIdFk = questionIdFk;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuestionIdFk() {
        return questionIdFk;
    }

    public void setQuestionIdFk(int questionIdFk) {
        this.questionIdFk = questionIdFk;
    }
}
