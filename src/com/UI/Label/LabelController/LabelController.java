package com.UI.Label.LabelController;

import com.UI.Label.LabelModel.LabelModel;
import com.UI.Label.LabelView.LabelContainer;
import com.UI.Label.LabelView.LabelView;

public class LabelController {

    private LabelModel currentInput = new LabelModel("Current input");
    private LabelModel currentSpeed = new LabelModel("Speed(ms)");

    private LabelView[] labelViewArray = new LabelView[2];

    private LabelContainer labelContainer;

    public LabelController(String initialInput, String initialSpeed) {
        setInitialValues(initialInput, initialSpeed);
        createViews();
        assignViewsToModels();
        labelContainer = new LabelContainer(labelViewArray);
    }

    private void setInitialValues(String initialInput, String initialSpeed){
        currentInput.setValue(initialInput);
        currentSpeed.setValue(initialSpeed);
    }

    private void createViews() {
        labelViewArray[0] = new LabelView(currentInput.getLabelName(), currentInput.getValue());
        labelViewArray[1] = new LabelView(currentSpeed.getLabelName(), currentSpeed.getValue());
    }

    private void assignViewsToModels(){
        currentInput.setLabelView(labelViewArray[0]);
        currentSpeed.setLabelView(labelViewArray[1]);
    }

    public LabelModel getCurrentInput() {
        return currentInput;
    }

    public LabelModel getCurrentSpeed() {
        return currentSpeed;
    }
}

