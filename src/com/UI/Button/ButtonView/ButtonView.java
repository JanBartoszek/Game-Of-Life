package com.UI.Button.ButtonView;

import com.Main.EventReceiver;
import com.UI.Button.ButtonModel.Enums.ButtonType;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ButtonView {

    private EventReceiver eventReceiver;
    private int heigth = 20;
    private int width = 120;
    private ButtonType buttonType;
    private Button button = new Button();

    public ButtonView(EventReceiver eventReceiver, ButtonType buttonType, String insideText) {
        this.eventReceiver = eventReceiver;
        this.buttonType = buttonType;
        button.setOnMouseClicked(clickedOnButton);
        button.setPrefHeight(heigth);
        button.setPrefWidth(width);
        button.setText(insideText);
    }

    public Button getButton() {
        return button;
    }

    public EventHandler<MouseEvent> clickedOnButton = e -> {
        eventReceiver.receiveEventData(this.buttonType);
    };
}
