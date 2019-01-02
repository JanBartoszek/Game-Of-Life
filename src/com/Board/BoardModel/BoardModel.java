package com.Board.BoardModel;

public class BoardModel {

    public static int heigth = 25;
    public static int width = 25;
    private DotModel[][] board = new DotModel[heigth][width];

    public BoardModel() {

    }

    public void createBoardModel() {
        for (int i = 0; i < BoardModel.heigth; i++) {
            for (int j = 0; j < BoardModel.width; j++) {
                getBoard()[i][j] = new DotModel();
            }
        }
    }

    public void newGeneration() {

        //count current neighbours for each dot
        countNeighbours();

        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {

                DotModel actualDot = board[i][j];

                //dot survives
                if (actualDot.isAlive() && (actualDot.getNeighbours() == 2 || actualDot.getNeighbours() == 3)) {
                    continue;

                //new dot is born
                } else if (board[i][j].isAlive() == false && actualDot.getNeighbours() == 3) {
                    board[i][j].setAlive(true);

                //dot dies due to overpopulation, underpopulation or just doesn't born.
                } else {
                    board[i][j].setAlive(false);
                }
            }
        }
    }

    private void countNeighbours() {
        for (int i = 0; i < BoardModel.heigth; i++) {
            for (int j = 0; j < BoardModel.width; j++) {
                DotModel actualDot = board[i][j];
                int actualDotNeighbours = countNeighboursForSingleDot(i, j);
                actualDot.setNeighbours(actualDotNeighbours);
            }
        }
    }

    private int countNeighboursForSingleDot(int givenI, int givenJ) {
        DotModel dotInTheMiddle = board[givenI][givenJ];
        int neighbours = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {

                //boundary conditions
                if (givenI + i >= 0 && givenI + i < heigth &&
                        givenJ + j >= 0 && givenJ + j < width) {

                    DotModel surroundingDot = board[givenI + i][givenJ + j];
                    if (surroundingDot.isAlive() && surroundingDot != dotInTheMiddle) {
                        neighbours ++;

                    }
                }
            }
        }
        return neighbours;
    }

    public void createDot(int givenHeight, int givenWidth) {
        board[givenHeight][givenWidth].setAlive(true);
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
