package com.UI.Button.ButtonView;

import com.Main.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class ButtonContainer {

    private ButtonView[] buttonViewArray;
    private VBox vBox = new VBox();

    public ButtonContainer(ButtonView[] buttonViewArray) {
        this.buttonViewArray = buttonViewArray;
        populatevBox();
        stylevBox();
        addvBoxToScene();
    }

    private void populatevBox(){
        for (ButtonView buttonView: buttonViewArray) {
            vBox.getChildren().add(buttonView.getButton());
        }
    }

    private  void stylevBox(){
        vBox.setStyle("-fx-background-color: seagreen");
        vBox.setSpacing(15);
        vBox.setAlignment(Pos.CENTER_RIGHT);
        vBox.setPadding(new Insets(15, 15, 15, 15));
    }

    private void addvBoxToScene(){
        Controller.StaticMainStage.setRight(vBox);
    }
}
