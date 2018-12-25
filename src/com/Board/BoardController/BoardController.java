package com.Board.BoardController;

import com.Board.BoardModel.BoardModel;
import com.Board.BoardModel.DotModel;
import com.Board.BoardView.BoardView;
import com.Board.BoardView.DotView;

public class BoardController {

    private EventReceiver eventReceiver = new EventReceiver(this);
    private BoardModel boardModel = new BoardModel();
    private BoardView boardView = new BoardView(boardModel.getBoard());

    public BoardController() {
        createBoard();
    }

    private void createBoard(){
        for (int i = 0; i < BoardModel.heigth ; i++) {
            for (int j = 0; j < BoardModel.width; j++) {
                boardModel.getBoard()[i][j] = new DotModel();
                DotView dotView = new DotView(this.eventReceiver, i, j);
                boardView.getDotViewArray()[i][j] = dotView;
                dotView.getDotRepresentation().setOnMouseClicked(dotView.clickedOnDot);
                boardView.getGridPane().add(dotView.getDotRepresentation(), j, i); //nie pameitam???
            }
        }

    }

    public void createGlider(int i, int j){
        boardModel.createGlider(i, j);
        boardView.createGlider(i, j);
    }


}
