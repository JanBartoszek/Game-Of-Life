package com.Board.BoardView;

import com.Main.EventReceiver;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class DotView {

    private EventReceiver eventReceiver;
    private Rectangle dotRepresentation = new Rectangle();
    private Color alive = Color.MEDIUMSEAGREEN;
    private Color dead = Color.DARKRED;
    private int y;
    private int x;

    public DotView(EventReceiver eventReceiver, int y, int x) {
        this.eventReceiver = eventReceiver;
        this.y = y;
        this.x = x;
        styleTheDot();
    }

    public EventHandler<MouseEvent> clickedOnDot = e -> {
        eventReceiver.receiveEventData(this.y, this.x);
    };

    public void setDotAlive() {
        this.dotRepresentation.setFill(alive);
    }

    public void setDotDead() {
        this.dotRepresentation.setFill(dead);
    }

    public Rectangle getDotRepresentation() {
        return dotRepresentation;
    }

    private void styleTheDot() {
        this.dotRepresentation.setHeight(20);
        this.dotRepresentation.setWidth(20);
        this.dotRepresentation.setArcHeight(5);
        this.dotRepresentation.setArcWidth(5);
    }
}
