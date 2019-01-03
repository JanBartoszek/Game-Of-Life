package com.UI.Label.LabelView;

import com.Main.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class LabelContainer {

    private LabelView[] labelViewArray;
    private VBox vBox = new VBox();

    public LabelContainer(LabelView[] labelViewArray) {
        this.labelViewArray = labelViewArray;
        populatevBox();
        stylevBox();
        addvBoxToScene();
    }

    private void populatevBox(){
        for (LabelView labelView: labelViewArray) {
            vBox.getChildren().add(labelView.getLabel());
        }
    }

    private  void stylevBox(){
        vBox.setStyle("-fx-background-color: seagreen");
        vBox.setSpacing(15);
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.setPadding(new Insets(15, 15, 15, 15));
    }

    private void addvBoxToScene(){
        Controller.StaticMainStage.setLeft(vBox);
    }
}
