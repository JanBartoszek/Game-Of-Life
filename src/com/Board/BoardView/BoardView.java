package com.Board.BoardView;

import com.Main.EventReceiver;
import com.Board.BoardModel.BoardModel;
import com.Board.BoardModel.DotModel;
import com.Main.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;


public class BoardView {

    private int heigth = BoardModel.heigth;
    private int width = BoardModel.width;
    private GridPane gridPane = new GridPane();
    private DotView[][] dotViewArray = new DotView[heigth][width];

    public BoardView(EventReceiver eventReceiver) {
        styleGrid();
        placeGrid();
        createBoardView(eventReceiver);
    }

    public DotView[][] getDotViewArray() {
        return dotViewArray;
    }

    public void createBoardView(EventReceiver eventReceiver) {
        for (int i = 0; i < BoardModel.heigth; i++) {
            for (int j = 0; j < BoardModel.width; j++) {
                DotView dotView = new DotView(eventReceiver, i, j);
                getDotViewArray()[i][j] = dotView;
                dotView.getDotRepresentation().setOnMouseClicked(dotView.clickedOnDot);
                gridPane.add(dotView.getDotRepresentation(), j, i);
            }
        }
    }

    public void updateBoardView(DotModel[][] dotModelArray) {
        gridPane.getChildren().clear();
        for (int i = 0; i < BoardModel.heigth; i++) {
            for (int j = 0; j < BoardModel.width; j++) {
                if (dotModelArray[i][j].isAlive()) {
                    dotViewArray[i][j].setDotAlive();
                    gridPane.add(dotViewArray[i][j].getDotRepresentation(), j, i);
                } else {
                    dotViewArray[i][j].setDotDead();
                    gridPane.add(dotViewArray[i][j].getDotRepresentation(), j, i);
                }
            }
        }
    }

    private void styleGrid() {
        gridPane.setStyle("-fx-background-color: seagreen");
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        gridPane.setPadding(new Insets(5, 5, 5, 5));

    }

    private void placeGrid() {
        gridPane.setAlignment(Pos.CENTER_RIGHT);
        Controller.StaticMainStage.setCenter(gridPane);
    }

}
