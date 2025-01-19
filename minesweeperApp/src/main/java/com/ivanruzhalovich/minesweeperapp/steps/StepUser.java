package com.ivanruzhalovich.minesweeperapp.steps;

public class StepUser {
    private String game_id;
    private int col;
    private int row;

    public StepUser(String game_id, int col, int row) {
        this.game_id = game_id;
        this.col = col;
        this.row = row;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "StepUser{" +
                "game_id=" + game_id +
                ", col=" + col +
                ", row=" + row +
                '}';
    }
}
