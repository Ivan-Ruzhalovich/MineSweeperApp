package com.ivanruzhalovich.minesweeperapp.mines;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class Mines {
    private int[][] mines;
    private  Map<Integer,int[]> positions;

    public Mines() {
    }

    public int[][] getMines() {
        return mines;
    }

    public void setMines(int[][] mines) {
        this.mines = mines;
    }

    public Map<Integer, int[]> getPositions() {
        return positions;
    }

    public void setPositions(Map<Integer, int[]> positions) {
        this.positions = positions;
    }

    public void generateMines(int count, int width, int height) {
        positions = new HashMap<>();
        mines = new int[width][height];
        Random ran = new Random();
        int i = 0;
        while (i < count) {
            int x = ran.nextInt(width);
            int y = ran.nextInt(height);
            if (mines[x][y] != -1) {
                mines[x][y] = -1;
                positions.put(i,new int[]{x,y});
                i++;
            }
        }
    }
}