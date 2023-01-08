package com.example.AppRestaurant.exception;

public class DaoEXception extends Exception{
    public DaoEXception() {
    }

    public DaoEXception(String message) {
        super(message);
    }

    public DaoEXception(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoEXception(Throwable cause) {
        super(cause);
    }

    public DaoEXception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
