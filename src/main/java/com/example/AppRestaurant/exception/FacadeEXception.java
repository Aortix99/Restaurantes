package com.example.AppRestaurant.exception;

public class FacadeEXception extends Exception{
    public FacadeEXception() {
    }

    public FacadeEXception(String message) {
        super(message);
    }

    public FacadeEXception(String message, Throwable cause) {
        super(message, cause);
    }

    public FacadeEXception(Throwable cause) {
        super(cause);
    }

    public FacadeEXception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
