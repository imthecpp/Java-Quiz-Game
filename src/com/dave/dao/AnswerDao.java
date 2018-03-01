package com.dave.dao;

import com.dave.api.IAnswerDao;
import com.dave.config.ConnectionFactory;
import com.dave.model.Answer;
import com.dave.model.Question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnswerDao implements IAnswerDao{

    @Override
    public ArrayList<Answer> getAnswerById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("SELECT * FROM answers_good WHERE question_id_fk="+id);
            ArrayList<Answer> answers = new ArrayList<>();
            Answer answer = null;

            while (resultSet.next()){
                answer = extractFromDb(resultSet);
                answers.add(answer);
            }

            return answers;

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    private Answer extractFromDb(ResultSet resultSet) throws SQLException{
        Answer answer = null;

        if(resultSet != null){
            answer = new Answer(
                    resultSet.getInt("answer_id"),
                    resultSet.getString("ans_description"),
                    resultSet.getInt("question_id_fk")
            );
            return answer;
        }
        return null;
    }
}
