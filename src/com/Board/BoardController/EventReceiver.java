package com.Board.BoardController;

import javafx.scene.shape.Circle;

import java.util.EventObject;

public class EventReceiver {

     BoardController boardController;

    public EventReceiver(BoardController boardController) {
        this.boardController = boardController;
    }

    public void receiveEventData(EventObject e , int i, int j){
        if (e.getSource() instanceof Circle){
            boardController.createGlider(i, j);
        }
    }

}
