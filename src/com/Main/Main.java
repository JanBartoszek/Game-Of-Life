package com.Main;


import com.SceneSpecs.SceneSpecs;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gameOfLife.fxml"));
        primaryStage.setTitle("GAME OF LIFE");
        primaryStage.setScene(new Scene(root, SceneSpecs.width, SceneSpecs.heigth));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
