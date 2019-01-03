package com.UI.Button.ButtonModel.Models;

import com.UI.Button.ButtonModel.Enums.ButtonType;

public abstract class ButtonModel {

    protected String insideText;
    protected ButtonType buttonType;

    public String getInsideText() {
        return insideText;
    }

    public ButtonType getButtonType() {
        return buttonType;
    }
}
