package com.ivanruzhalovich.minesweeperapp.exceptions;

public class EndOfGameException extends RuntimeException {
    public EndOfGameException(String message) {
        super(message);
    }
}
