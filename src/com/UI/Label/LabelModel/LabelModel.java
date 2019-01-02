package com.UI.Label.LabelModel;

import com.UI.Label.LabelView.LabelView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LabelModel implements PropertyChangeListener{

    private String labelName;
    private String value;
    private LabelView labelView;

    public LabelModel(String labelName){
        this.labelName = labelName;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.setValue((String) evt.getNewValue());
        labelView.setLabel((String) evt.getNewValue());
    }

    public String getLabelName() {
        return labelName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setLabelView(LabelView labelView) {
        this.labelView = labelView;
    }
}
