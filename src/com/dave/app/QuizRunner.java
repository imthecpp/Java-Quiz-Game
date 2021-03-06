package com.dave.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuizRunner extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("/com/dave/QuizView.fxml"));
            System.out.println();
            primaryStage.setTitle("Java Quiz Game");
            primaryStage.setResizable(false);
            primaryStage.setScene(new Scene(root, 600, 366));
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
}
