package com.Board.BoardView;

import com.Board.BoardModel.BoardModel;
import com.Board.BoardModel.DotModel;

import com.Main.Controller;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class BoardView {

    private int heigth = BoardModel.heigth;
    private int width = BoardModel.width;
    private GridPane gridPane = new GridPane();
    private DotView[][] dotViewArray = new DotView[heigth][width];

    public BoardView(DotModel[][] board) {
        placeGrid();
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public DotView[][] getDotViewArray() {
        return dotViewArray;
    }

    public void createGlider(int givenHeight, int givenWidth) {
        try {
            Circle circleToBeChanged = (Circle) getNodeFromGridPane(gridPane, givenHeight - 1, givenWidth);
            circleToBeChanged.setFill(Color.BLUE);

            circleToBeChanged = (Circle) getNodeFromGridPane(gridPane, givenHeight, givenWidth + 1);
            circleToBeChanged.setFill(Color.BLUE);

            for (int i = -1; i < 2; i++) {
                circleToBeChanged = (Circle) getNodeFromGridPane(gridPane, givenHeight + 1, givenWidth + i);
                circleToBeChanged.setFill(Color.BLUE);
            }
        } catch (java.lang.NullPointerException e) {
            System.out.println(e);
        }
    }

    private Node getNodeFromGridPane(GridPane gridPane, int row, int col) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    private void placeGrid() {
        gridPane.setId("gridPane");
        gridPane.setAlignment(Pos.CENTER);
        Controller.StaticMainStage.setCenter(gridPane);
    }

}
