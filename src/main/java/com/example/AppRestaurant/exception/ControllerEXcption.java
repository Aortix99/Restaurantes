package com.example.AppRestaurant.exception;

public class ControllerEXcption extends Exception{
    public ControllerEXcption() {
    }

    public ControllerEXcption(String message) {
        super(message);
    }

    public ControllerEXcption(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerEXcption(Throwable cause) {
        super(cause);
    }

    public ControllerEXcption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
