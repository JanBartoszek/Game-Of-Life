package com.UI.Button.ButtonController;

import com.Main.EventReceiver;
import com.UI.Button.ButtonModel.Enums.InputType;
import com.UI.Button.ButtonModel.Models.*;
import com.UI.Button.ButtonView.ButtonContainer;
import com.UI.Button.ButtonView.ButtonView;

public class ButtonController {

    private EventReceiver eventReceiver;

    private ButtonSpeedUp buttonSpeedUp = new ButtonSpeedUp();
    private ButtonSlowDown buttonSlowDown = new ButtonSlowDown();
    private ButtonPause buttonPause = new ButtonPause();
    private ButtonResume buttonResume = new ButtonResume();
    private ButtonChangeInput buttonChangeInput = new ButtonChangeInput();

    private ButtonView[] buttonViewArray;

    private ButtonContainer buttonContainer;

    public ButtonController(EventReceiver eventReceiver) {
        this.eventReceiver = eventReceiver;
        createViews();
        buttonContainer = new ButtonContainer(buttonViewArray);
    }

    private void createViews(){
        buttonViewArray = new ButtonView[]{
                new ButtonView(eventReceiver, buttonSpeedUp.getButtonType(), buttonSpeedUp.getInsideText()),
                new ButtonView(eventReceiver, buttonSlowDown.getButtonType(), buttonSlowDown.getInsideText()),
                new ButtonView(eventReceiver, buttonPause.getButtonType(), buttonPause.getInsideText()),
                new ButtonView(eventReceiver, buttonResume.getButtonType(), buttonResume.getInsideText()),
                new ButtonView(eventReceiver, buttonChangeInput.getButtonType(), buttonChangeInput.getInsideText()),
        };
    }

    public ButtonChangeInput getButtonChangeInput() {
        return buttonChangeInput;
    }

    public void changeInput(){
        buttonChangeInput.changeInputType();
    }

    public InputType getCurrentInput(){
        return buttonChangeInput.getCurrentInputType();
    }
}
