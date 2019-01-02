package com.Board.BoardModel;

public class DotModel {

    private boolean isAlive;
    private int neighbours;

    public boolean isAlive() {
        return isAlive;
    }

    public int getNeighbours() {
        return neighbours;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setNeighbours(int neighbours) {
        this.neighbours = neighbours;
    }
}
