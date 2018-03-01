package com.dave.impl;

import com.dave.model.Question;

import java.util.ArrayList;

public class Game {

    private ArrayList<Question> questions;
    private int questionCounter = 0;



    public Game(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Question getQuestion(){


        if(questionCounter >= 0 && questionCounter < questions.size()){
            return questions.get(questionCounter++);
        }

        return null;
    }

    public boolean checkCorrectAnswer(Question question, String toggleGroupValue){
        if(question != null){
            System.out.println(question.getDescription());
            int answerId = question.getCorrectAnswerId() - 1;
            if(question.getAnswers().get(answerId).getDescription().equals(toggleGroupValue)){

                return true;
            }
        }
        return false;
    }


}
