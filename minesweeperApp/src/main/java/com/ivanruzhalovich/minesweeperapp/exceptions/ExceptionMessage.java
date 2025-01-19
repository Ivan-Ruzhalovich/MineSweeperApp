package com.ivanruzhalovich.minesweeperapp.exceptions;

public class ExceptionMessage {
    String message;

    public ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExceptionMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
