package com.ivanruzhalovich.minesweeperapp.service;

import com.ivanruzhalovich.minesweeperapp.mines.Mines;
import com.ivanruzhalovich.minesweeperapp.newGame.Game;
import com.ivanruzhalovich.minesweeperapp.steps.StepUser;

public interface MinesweeperService {
    public void createGame(Game game,Mines mines);
    public void updateFieldAfterUserStep(StepUser stepUser, Game game, Mines mines);
}
