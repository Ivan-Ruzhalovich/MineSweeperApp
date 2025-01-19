package com.ivanruzhalovich.minesweeperapp.exceptions;

public class AlreadyCheckedFieldException extends RuntimeException{
    public AlreadyCheckedFieldException(String message){
        super(message);
    }
}
