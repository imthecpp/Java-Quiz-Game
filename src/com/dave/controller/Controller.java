package com.dave.controller;


import com.dave.api.IQuestionDao;
import com.dave.dao.QuestionDao;
import com.dave.model.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.util.ArrayList;


public class Controller {
    @FXML
    private TextArea questionTextArea;
    @FXML
    private RadioButton anwerRB1, anwerRB2, anwerRB3, anwerRB4;
    @FXML
    private ToggleGroup toggleGroup = new ToggleGroup();
    private IQuestionDao questionDao = new QuestionDao();

    private int questionCounter;
    private ArrayList<Question> questions;
    private int userPoints = 0;

    @FXML
    public void initialize() {
        anwerRB1.setToggleGroup(toggleGroup);
        anwerRB2.setToggleGroup(toggleGroup);
        anwerRB3.setToggleGroup(toggleGroup);
        anwerRB4.setToggleGroup(toggleGroup);
        questionCounter = 0;

        onStartQuiz();

    }

    @FXML
    public void onStartQuiz() {
        questions = questionDao.getAllQuestions();
        if (questions != null) {
            displayQuestion(questionCounter);
        }

    }

    @FXML
    public void onNextQuestion(ActionEvent actionEvent) {
        //sprawdź odpowiedź
        //jeśli jest kolejne pytanie to wyświetl

        String toogleGroupValue = null;
        RadioButton selectedRadioButton = null;
        if (toggleGroup.getSelectedToggle() != null) {

            selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            toogleGroupValue = selectedRadioButton.getText();

            int correctAnswer = questions.get(questionCounter).getCorrectAnswerId();

            if (toogleGroupValue.equals(questions.get(questionCounter).getAnswers().get(correctAnswer - 1).getDescription())) {
                userPoints += +5;
                System.out.println("points" + userPoints);
            }

            questionCounter++;
            if (questionCounter < questions.size() && selectedRadioButton != null && toogleGroupValue != null) {
                selectedRadioButton.setSelected(false);
                displayQuestion(questionCounter);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("You ended quiz with result = " + userPoints);
                alert.showAndWait();
            }
        }
    }


    private void displayQuestion(int questionCounter) {
        questionTextArea.setPromptText(questions.get(questionCounter).getDescription());
        anwerRB1.setText(questions.get(questionCounter).getAnswers().get(0).getDescription());
        anwerRB2.setText(questions.get(questionCounter).getAnswers().get(1).getDescription());
        anwerRB3.setText(questions.get(questionCounter).getAnswers().get(2).getDescription());
        anwerRB4.setText(questions.get(questionCounter).getAnswers().get(3).getDescription());
    }

}
