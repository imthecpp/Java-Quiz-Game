package com.dave.api;

import com.dave.model.Answer;
import com.dave.model.Question;

import java.util.ArrayList;

public interface IAnswerDao {

    ArrayList<Answer> getAnswerById(int id);

}
