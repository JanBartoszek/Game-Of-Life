package com.Main;

import com.Board.BoardController.BoardController;
import com.UI.Button.ButtonController.ButtonController;
import com.UI.Label.LabelController.LabelController;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public BorderPane MainStage;
    public static BorderPane StaticMainStage;

    private BoardController boardController;
    private ButtonController buttonController;
    private LabelController labelController;
    private EventReceiver eventReceiver;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        StaticMainStage = this.MainStage;

        eventReceiver = new EventReceiver();
        boardController = new BoardController(eventReceiver);
        buttonController = new ButtonController(eventReceiver);
        labelController = new LabelController(buttonController.getCurrentInput().toString(), String.valueOf( boardController.getGameLoop().getSpeed()));
        eventReceiver.setControllers(boardController, buttonController);
        attachObservers();

    }

    private void attachObservers(){
        boardController.getGameLoop().addPropertyChangeListener(labelController.getCurrentSpeed());
        buttonController.getButtonChangeInput().addPropertyChangeListener(labelController.getCurrentInput());
    }
}


