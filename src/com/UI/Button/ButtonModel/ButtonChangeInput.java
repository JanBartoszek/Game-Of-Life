package com.UI.Button.ButtonModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;

public class ButtonChangeInput extends ButtonModel {

    private LinkedList<InputType> inputTypeLinkedList = new LinkedList();
    private InputType currentInputType;
    private PropertyChangeSupport support;


    public ButtonChangeInput() {
        insideText = "Change input";
        buttonType = ButtonType.CHANGE_INPUT;
        populateInputTypeLinkedList();
        currentInputType = inputTypeLinkedList.getFirst();
        support = new PropertyChangeSupport(this);
    }

    public InputType getCurrentInputType() {
        return currentInputType;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }


    public void changeInputType() {
        int indexOfCurrentInputType = inputTypeLinkedList.indexOf(currentInputType);
        if (inputTypeLinkedList.listIterator(indexOfCurrentInputType + 1).hasNext()) {
            InputType nextInputType = inputTypeLinkedList.listIterator(indexOfCurrentInputType + 1).next();
            support.firePropertyChange("speed", String.valueOf(this.currentInputType) , String.valueOf(nextInputType));
            this.currentInputType = nextInputType;
        } else {
            InputType nextInputType = inputTypeLinkedList.getFirst();
            support.firePropertyChange("speed", String.valueOf(this.currentInputType) , String.valueOf(nextInputType));
            this.currentInputType = nextInputType;
        }
    }

    private void populateInputTypeLinkedList(){
        for ( InputType inputType : InputType.values()) {
            inputTypeLinkedList.add(inputType);
        }
    }


}
