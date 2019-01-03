package com.Board.BoardModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class BoardModelTest {

    @org.junit.jupiter.api.Test
    void createBoardModel() {

        BoardModel boardModel = new BoardModel();

        //checks if the created board is right height and width
        assertEquals(boardModel.getBoard().length, BoardModel.heigth);
        assertEquals(boardModel.getBoard()[0].length, BoardModel.width);

        //checks if the first and last dots in the board are dead on creation
        assertEquals(boardModel.getBoard()[0][0].isAlive(), false);
        assertEquals(boardModel.getBoard()[BoardModel.heigth - 1][BoardModel.width - 1].isAlive(), false);

    }

    @org.junit.jupiter.api.Test
    void newGeneration() {

        BoardModel boardModel = new BoardModel();

        //check three dots align horizontally
        boardModel.getBoard()[10][9].setAlive(true);
        boardModel.getBoard()[10][10].setAlive(true);
        boardModel.getBoard()[10][11].setAlive(true);

        boardModel.newGeneration();

        /***
         *
         * o o o
         *
         * should become
         *
         *   o
         *   o
         *   o
         */


        //dots should die due to underpopulation
        assertEquals(boardModel.getBoard()[10][9].isAlive(), false);
        assertEquals(boardModel.getBoard()[10][11].isAlive(), false);

        //dot should remain alive, because of two alive neighbours in the previous generation
        assertEquals(boardModel.getBoard()[10][10].isAlive(), true);

        //new dots born because they had three alive neighbours
        assertEquals(boardModel.getBoard()[9][10].isAlive(), true);
        assertEquals(boardModel.getBoard()[11][10].isAlive(), true);

        //reset
        boardModel = new BoardModel();

        //check glider pattern
        boardModel.getBoard()[10][10].setAlive(true);
        boardModel.getBoard()[11][11].setAlive(true);
        for (int i = -1; i < 2; i++) {
            boardModel.getBoard()[12][10+i].setAlive(true);
        }

        boardModel.newGeneration();

        /***
         *
         *   o
         *     o
         * o o o
         *
         * should become
         *
         * o   o
         *   o o
         *   o
         */

        //was alive and now is dead
        assertEquals(boardModel.getBoard()[10][10].isAlive(), false);

        //was dead and now is alive
        assertEquals(boardModel.getBoard()[11][9].isAlive(), true);

        //was alive and remains that way
        assertEquals(boardModel.getBoard()[11][11].isAlive(), true);

        //was alive and now is dead
        assertEquals(boardModel.getBoard()[12][9].isAlive(), false);

        //was alive and remains that way
        assertEquals(boardModel.getBoard()[12][10].isAlive(), true);
        assertEquals(boardModel.getBoard()[12][11].isAlive(), true);

        //was dead and now is alive
        assertEquals(boardModel.getBoard()[13][10].isAlive(), true);
    }

    @org.junit.jupiter.api.Test
    void countNeighboursForSingleDot() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        BoardModel boardModel = new BoardModel();


        //case like the above
        boardModel.getBoard()[10][9].setAlive(true);
        boardModel.getBoard()[10][10].setAlive(true);
        boardModel.getBoard()[10][11].setAlive(true);

        Method method = BoardModel.class.getDeclaredMethod("countNeighboursForSingleDot", int.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(boardModel, 10, 10 );
        assertEquals(result, 2);


        //case when dead dot is surrounded by living dots
        boardModel.getBoard()[9][9].setAlive(true);
        boardModel.getBoard()[9][10].setAlive(true);
        boardModel.getBoard()[9][11].setAlive(true);

        boardModel.getBoard()[10][10].setAlive(false);

        boardModel.getBoard()[11][9].setAlive(true);
        boardModel.getBoard()[11][10].setAlive(true);
        boardModel.getBoard()[11][11].setAlive(true);

        result = (int) method.invoke(boardModel, 10, 10 );
        assertEquals(result, 8);


        //case when alive dot is surrounded by living dots
        boardModel.getBoard()[10][10].setAlive(true);
        result = (int) method.invoke(boardModel, 10, 10 );
        assertEquals(result, 8);


        //case when alive dot is at the border of the scene
        boardModel.getBoard()[0][0].setAlive(true);
        boardModel.getBoard()[1][1].setAlive(true);
        result = (int) method.invoke(boardModel, 0, 0 );
        assertEquals(result, 1);
    }
}