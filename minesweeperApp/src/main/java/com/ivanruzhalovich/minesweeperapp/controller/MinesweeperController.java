package com.ivanruzhalovich.minesweeperapp.controller;

import com.ivanruzhalovich.minesweeperapp.mines.Mines;
import com.ivanruzhalovich.minesweeperapp.newGame.Game;
import com.ivanruzhalovich.minesweeperapp.service.MinesweeperService;
import com.ivanruzhalovich.minesweeperapp.steps.StepUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class MinesweeperController {

    @Autowired
    MinesweeperService minesweeperService;

    @Autowired
    Mines mines;

    @Autowired
    Game game;

    @CrossOrigin()
    @PostMapping("/new")
    public ResponseEntity<Game> newGame ( @RequestBody Game game){
        this.game = game;
        minesweeperService.createGame(this.game,mines);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/turn")
    public ResponseEntity<Game> turn(@RequestBody StepUser step){
        minesweeperService.updateFieldAfterUserStep(step,game,mines);
        return new ResponseEntity<>(game,HttpStatus.OK);
    }
}