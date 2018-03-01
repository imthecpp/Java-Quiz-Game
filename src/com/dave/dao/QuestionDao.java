package com.dave.dao;

import com.dave.api.IAnswerDao;
import com.dave.api.IQuestionDao;
import com.dave.config.ConnectionFactory;
import com.dave.model.Answer;
import com.dave.model.Question;

import java.sql.*;
import java.util.ArrayList;

public class QuestionDao implements IQuestionDao {

    @Override
    public ArrayList<Question> getAllQuestions() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("SELECT * FROM questions");

            ArrayList<Question> questions = new ArrayList<>();
            ArrayList<Answer> answers = new ArrayList<>();
            Question question = null;
            IAnswerDao answerDao = new AnswerDao();
            while (resultSet.next()){
                question = extractRowDb(resultSet);
                answers = answerDao.getAnswerById(question.getQuestionId());

                question.setAnswers(answers);
                questions.add(question);
                //System.out.println(question.getDescription());
            }

            return questions;

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }

        return null;
    }

    //single row mapping
    private Question extractRowDb(ResultSet resultSet) throws SQLException{
        Question question = null;

        if(resultSet != null){
            question = new Question(
                    resultSet.getInt("question_id"),
                    resultSet.getString("description"),
                    resultSet.getInt("correct_answer_id")
            );
            return question;
        }
        return null;
    }

}
