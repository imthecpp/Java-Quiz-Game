package com.dave.app;

import com.dave.dao.QuestionDao;
import com.dave.impl.Game;
import com.dave.model.Answer;
import com.dave.model.Question;

import java.util.ArrayList;

public class JavaQuizTester {

    public static void main(String[] args) {
	// write your code here
        QuestionDao questionDao = new QuestionDao();
        ArrayList<Question> questions = questionDao.getAllQuestions();
        Game game = new Game(questions);

//        System.out.println(game.getQuestion(0).getDescription());
//
//        for(Answer a : game.getQuestion(0).getAnswers()){
//            System.out.println(a.getDescription());
//        }



        //System.out.println(questions.get(0).getAnswers().get(0).getDescription());

//        System.out.println(questions.get(questionCounter).getDescription());
//
//        for(int i = 0; i < questions.get(questionCounter).getAnswers().size(); i++){
//            System.out.println(questions.get(questionCounter).getAnswers().get(i).getDescription());
//        }





    }
}
