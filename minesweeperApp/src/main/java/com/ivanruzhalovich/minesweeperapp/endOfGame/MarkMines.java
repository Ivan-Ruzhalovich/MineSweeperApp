package com.ivanruzhalovich.minesweeperapp.endOfGame;

import com.ivanruzhalovich.minesweeperapp.mines.Mines;
import com.ivanruzhalovich.minesweeperapp.newGame.Game;

public interface MarkMines {
    void mark(Game game, Mines mines);
    void resultOfGame(Game game,Mines mines);
}