package com.Board.BoardController;

import com.Board.BoardModel.BoardModel;
import com.Board.BoardView.BoardView;
import com.Main.EventReceiver;

public class BoardController {

    private EventReceiver eventReceiver;
    private BoardModel boardModel = new BoardModel();
    private BoardView boardView = new BoardView();
    private GameLoop gameLoop = new GameLoop(this);

    public BoardController(EventReceiver eventReceiver) {
        this.eventReceiver = eventReceiver;
        boardModel.createBoardModel();
        boardView.createBoardView(this.eventReceiver);
        gameLoop.loop();
    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

    public void newGeneration(){
        boardModel.newGeneration();
        boardView.updateBoardView(boardModel.getBoard());
    }

    public void createDot(int i, int j) {
        boardModel.createDot(i, j);
        boardView.updateBoardView(boardModel.getBoard());
    }

    public void createGlider(int i, int j) {
        boardModel.createGlider(i, j);
        boardView.updateBoardView(boardModel.getBoard());
    }

}
