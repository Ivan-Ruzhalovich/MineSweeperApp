package com.ivanruzhalovich.minesweeperapp.service;

import com.ivanruzhalovich.minesweeperapp.CheckGame;
import com.ivanruzhalovich.minesweeperapp.endOfGame.Loss;
import com.ivanruzhalovich.minesweeperapp.endOfGame.Win;
import com.ivanruzhalovich.minesweeperapp.exceptions.MinesCountException;
import com.ivanruzhalovich.minesweeperapp.mines.Mines;
import com.ivanruzhalovich.minesweeperapp.newGame.Game;
import com.ivanruzhalovich.minesweeperapp.steps.StepUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinesweeperServiceImpl implements MinesweeperService {

    @Autowired
    Win win;

    @Autowired
    Loss loss;

    @Override
    public void createGame(Game game, Mines mines) {
        int maxMinesCount = game.getHeight() * game.getWidth() - 1;//создание новой игры
        if (game.getMines_count() <= (maxMinesCount) && game.getMines_count() > 0) {
            game.init(mines);//обнуляем массив игры и заполняем массив мин
        } else throw new MinesCountException("Количество мин должно быть не менее 1 и не более " + maxMinesCount);
    }

    @Override
    public void updateFieldAfterUserStep(StepUser stepUser, Game game, Mines mines) {
        CheckGame.checkGameId(game.getGame_id(),stepUser.getGame_id());
        CheckGame.isEndOfGame(game);
        int x = stepUser.getRow();
        int y = stepUser.getCol();
        CheckGame.checkField(game, x, y);
        if (mines.getMines()[x][y] == -1) {//попали на мину, заканчиваем игру
            loss.resultOfGame(game,mines);
            return;
        }
        CheckGame.near(x, y, game, mines.getMines());
        if(game.getCountFreeFields()==0){//Победа!
            win.resultOfGame(game,mines);
        }

    }
}