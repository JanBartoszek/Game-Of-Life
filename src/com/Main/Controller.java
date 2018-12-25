package com.Main;

import com.Board.BoardController.BoardController;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public BorderPane MainStage;
    public static BorderPane StaticMainStage;

    private BoardController boardController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        StaticMainStage = this.MainStage;

        boardController = new BoardController();



    }
}


