package com.ivanruzhalovich.minesweeperapp.newGame;

import com.ivanruzhalovich.minesweeperapp.mines.Mines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;
@Component
public class Game {
    private UUID game_id;
    private int width;
    private int height;
    private int mines_count;
    private boolean completed;
    private String[][] field;
    private int countFreeFields;

    @Autowired
    Mines mines;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Game(int width, int height, int mines_count) {
        this.width = width;
        this.height = height;
        this.mines_count = mines_count;
    }

    public Game() {
    }

    public UUID getGame_id() {
        return game_id;
    }

    public void setGame_id(UUID game_id) {
        this.game_id = game_id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMines_count() {
        return mines_count;
    }

    public void setMines_count(int mines_count) {
        this.mines_count = mines_count;
    }

    public String[][] getField() {
        return field;
    }

    public void setField(String[][] field) {
        this.field = field;
    }

    public int getCountFreeFields() {
        return countFreeFields;
    }

    public void setCountFreeFields(int countFreeFields) {
        this.countFreeFields = countFreeFields;
    }

    @Override
    public String toString() {
        return "Game{" +
                "game_id=" + game_id +
                ", width=" + width +
                ", height=" + height +
                ", mines_count=" + mines_count +
                ", field=" + Arrays.toString(field) +
                '}';
    }
    public void init(Mines mines){
        countFreeFields = width * height - mines_count;
        this.setGame_id(UUID.randomUUID());//генерируем UUID игры
        mines.generateMines(mines_count,width,height);
        this.setField(new String[this.getHeight()][this.getWidth()]);
        for (String[] chars:field)
            Arrays.fill(chars," ");
        this.setCompleted(false);//Флаг продолжающейся игры
    }
}
