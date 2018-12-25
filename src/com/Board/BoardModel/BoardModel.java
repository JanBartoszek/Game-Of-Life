package com.Board.BoardModel;

public class BoardModel {

    public static int heigth = 25;
    public static int width = 25;
    private DotModel[][] board = new DotModel[heigth][width];
    private DotModel[][] swappingBoard = new DotModel[heigth][width];

    public BoardModel() {

    }

    public void createGlider(int givenHeight, int givenWidth) {

        try {
            board[givenHeight - 1][givenWidth].setAlive(true);
            board[givenHeight][givenWidth + 1].setAlive(true);
            for (int i = -1; i < 2; i++) {
                board[givenHeight + 1][givenWidth + i].setAlive(true);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

    }

    public DotModel[][] getBoard() {
        return board;
    }
}
