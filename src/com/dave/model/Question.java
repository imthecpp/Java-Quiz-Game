package com.dave.model;

import java.util.ArrayList;

public class Question {

    private int questionId;
    private String description;
    private int correctAnswerId;
    private ArrayList<Answer> answers;

    public Question(int questionId, String description, int correctAnswerId) {
        this.questionId = questionId;
        this.description = description;
        this.correctAnswerId = correctAnswerId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCorrectAnswerId() {
        return correctAnswerId;
    }

    public void setCorrectAnswerId(int correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
}
