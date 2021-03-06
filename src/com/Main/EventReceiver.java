package com.Main;

import com.Board.BoardController.BoardController;
import com.UI.Button.ButtonController.ButtonController;
import com.UI.Button.ButtonModel.Enums.ButtonType;
import com.UI.Button.ButtonModel.Enums.InputType;

public class EventReceiver {

     BoardController boardController;
     ButtonController buttonController;

     public void setControllers(BoardController boardController, ButtonController buttonController){
         this.boardController = boardController;
         this.buttonController = buttonController;
     }

    public void receiveEventData(int height, int width){
            if (buttonController.getCurrentInput() == InputType.DOT) {
                boardController.createDot(height, width);
            }
             else if (buttonController.getCurrentInput() == InputType.GLIDER) {
                boardController.createGlider(height, width);
            }
    }

    public void receiveEventData(ButtonType buttonType){
         switch (buttonType){
             case SPEED_UP:
                 boardController.getGameLoop().speedUp();
                 break;
             case SLOW_DOWN:
                 boardController.getGameLoop().slowDown();
                 break;
             case PAUSE: boardController.getGameLoop().stopThread();
                 break;
             case RESUME: boardController.getGameLoop().resumeThread();
                 break;
             case CHANGE_INPUT: buttonController.changeInput();
                break;
         }
    }
}
