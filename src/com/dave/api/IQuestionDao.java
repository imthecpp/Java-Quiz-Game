package com.dave.api;

import com.dave.model.Question;

import java.util.ArrayList;

public interface IQuestionDao {

    ArrayList<Question> getAllQuestions();
}
