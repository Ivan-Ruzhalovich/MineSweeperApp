package com.ivanruzhalovich.minesweeperapp.exceptions;

public class IncorrectGameIdException extends RuntimeException{
    public IncorrectGameIdException(String message){
        super(message);
    }
}
