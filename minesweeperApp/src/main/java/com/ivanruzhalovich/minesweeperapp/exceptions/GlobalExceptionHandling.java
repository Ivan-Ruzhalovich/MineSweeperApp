package com.ivanruzhalovich.minesweeperapp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> incorrectGameIdExceptionHandler(IncorrectGameIdException e){
        return new ResponseEntity<>(new ExceptionMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> minesCountExceptionHandler(MinesCountException e){
        return new ResponseEntity<>(new ExceptionMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> noGameExceptionHandler(NoGameException e){
        return new ResponseEntity<>(new ExceptionMessage(e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> endOfGameExceptionHandler(EndOfGameException e){
        return new ResponseEntity<>(new ExceptionMessage(e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> alreadyCheckedFieldExceptionHandler(AlreadyCheckedFieldException e){
        return new ResponseEntity<>(new ExceptionMessage(e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> otherExceptionHandler(RuntimeException e){
        return new ResponseEntity<>(new ExceptionMessage(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
}