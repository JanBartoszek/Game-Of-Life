package com.Board.BoardController;

import com.Board.BoardModel.BoardModel;
import com.Board.BoardView.BoardView;
import com.Main.EventReceiver;

public class BoardController {

    private EventReceiver eventReceiver;
    private BoardModel boardModel;
    private BoardView boardView;
    private GameLoop gameLoop;

    public BoardController(EventReceiver eventReceiver) {
        this.eventReceiver = eventReceiver;
        boardModel = new BoardModel();
        boardView = new BoardView(this.eventReceiver);
        gameLoop = new GameLoop(this);
        gameLoop.loop();
    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

    public void newGeneration(){
        boardModel.newGeneration();
        boardView.updateBoardView(boardModel.getBoard());
    }

    public void createDot(int height, int width) {
        boardModel.createDot(height, width);
        boardView.updateBoardView(boardModel.getBoard());
    }

    public void createGlider(int height, int width) {
        boardModel.createGlider(height, width);
        boardView.updateBoardView(boardModel.getBoard());
    }

}
