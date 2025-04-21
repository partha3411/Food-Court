package com.example.parthajavafinalproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        SceneSwitcher.setStage(stage);
        try {
            SceneSwitcher.switchTo("loginScene");
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Food Court Management System");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }




}