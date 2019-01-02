package com.UI.Label.LabelView;

import javafx.scene.control.Label;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LabelView{

    private Label label = new Label();
    private String labelName;

    public LabelView(String labelName, String value) {
        this.labelName = labelName;
        setLabel(value);
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(String value) {
        label.setText(labelName + " : " + value);
    }

}
