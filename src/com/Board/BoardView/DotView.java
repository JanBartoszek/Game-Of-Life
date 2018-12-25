package com.Board.BoardView;

import com.Board.BoardController.EventReceiver;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class DotView {

    private EventReceiver eventReceiver;
    private Circle dotRepresentation = new Circle();
    private Color alive = Color.GREEN;
    private Color dead = Color.RED;
    private int y;
    private int x;

    public DotView(EventReceiver eventReceiver, int y, int x) {
        this.eventReceiver = eventReceiver;
        this.dotRepresentation.setRadius(10);
        this.dotRepresentation.setFill(dead);
        this.y = y;
        this.x = x;
    }

    public EventHandler<MouseEvent> clickedOnDot = e -> {
        eventReceiver.receiveEventData(e, this.y, this.x);
    };

    public static void setDotFill(){

    }

    public Circle getDotRepresentation() {
        return dotRepresentation;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}
