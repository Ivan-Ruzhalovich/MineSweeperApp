package com.ivanruzhalovich.minesweeperapp.endOfGame;

import com.ivanruzhalovich.minesweeperapp.mines.Mines;
import com.ivanruzhalovich.minesweeperapp.newGame.Game;
import org.springframework.stereotype.Component;

@Component
public class Win implements MarkMines{
    @Override
    public void mark(Game game, Mines mines) {
        for (int i = 0; i < mines.getPositions().size(); i++) {
            int[] pos = mines.getPositions().get(i);
            game.getField()[pos[0]][pos[1]]= "M";
        }
    }

    @Override
    public void resultOfGame(Game game,Mines mines) {
        game.setCompleted(true); //попали на мину, заканчиваем игру
        mark(game,mines);
    }
}
