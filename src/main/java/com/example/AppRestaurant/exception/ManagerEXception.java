package com.example.AppRestaurant.exception;

public class ManagerEXception extends Exception{
    public ManagerEXception() {
    }

    public ManagerEXception(String message) {
        super(message);
    }

    public ManagerEXception(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerEXception(Throwable cause) {
        super(cause);
    }

    public ManagerEXception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

