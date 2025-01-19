package com.ivanruzhalovich.minesweeperapp;

import com.ivanruzhalovich.minesweeperapp.exceptions.AlreadyCheckedFieldException;
import com.ivanruzhalovich.minesweeperapp.exceptions.EndOfGameException;
import com.ivanruzhalovich.minesweeperapp.exceptions.IncorrectGameIdException;
import com.ivanruzhalovich.minesweeperapp.newGame.Game;
import com.ivanruzhalovich.minesweeperapp.steps.StepUser;

import java.util.UUID;

public class CheckGame {

    public static void checkGameId(UUID gameUUID, String stepUserUUID) {
        if (!gameUUID.toString().equals(stepUserUUID))
            throw new IncorrectGameIdException("Такой игры не существует, либо id устарел");

    }

    public static void isEndOfGame(Game game) {
        if (game.getCountFreeFields()==0)
            game.setCompleted(true);
        if (game.isCompleted())
            throw new EndOfGameException("Конец игры, ходов больше нет!");
    }

    public static void checkField(Game game, int x, int y) {
        if (!game.getField()[x][y].equals(" "))
            throw new AlreadyCheckedFieldException("Эта ячейка уже проверена");
    }

    public static boolean checkBeforeNextNearCheck(Game game, int[][] minesMas, int x, int y) {
        String[][] gameMas = game.getField();
        return (x < 0 || y < 0 || x >= gameMas.length || y >= gameMas[0].length
                || (minesMas[x][y] == -1) || !gameMas[x][y].equals(" "));
    }

    public static void near(int x, int y, Game game, int[][] mines) {//поиск мин рядом с исходной ячейки
        String[][] buf = game.getField();
        int count = 0;
        if (CheckGame.checkBeforeNextNearCheck(game, mines, x, y)) {
            return;
        }
        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0 || i >= buf.length) //исключаю выход за пределы
                continue;
            for (int j = y - 1; j <= y + 1; j++) {
                if ((j < 0) || (j >= buf.length) || (i == x && j == y)) //исключаю выход за пределы массива и проверку исходной ячейки
                    continue;
                if (mines[i][j] == -1) //мина рядом
                    count++;
            }
        }
        if (game.isCompleted()) {
            buf[x][y] = String.valueOf(count);
            game.setField(buf);
            return;
        }
        if (count != 0) { //нашли мины рядом
            buf[x][y] = String.valueOf(count);
            game.setCountFreeFields(game.getCountFreeFields()-1);
            game.setField(buf);
        } else {//на нашли мины рядом, рекурсивно проверяем все соседние ячейки
            buf[x][y] = String.valueOf(0);
            game.setCountFreeFields(game.getCountFreeFields()-1);
            near(x - 1, y - 1, game, mines);
            near(x - 1, y, game, mines);
            near(x - 1, y + 1, game, mines);
            near(x, y - 1, game, mines);
            near(x, y + 1, game, mines);
            near(x + 1, y - 1, game, mines);
            near(x + 1, y, game, mines);
            near(x + 1, y + 1, game, mines);
        }
    }
}
