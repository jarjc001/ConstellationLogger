package com.ConstellationLogger.service;

public class ServiceLayerException extends Exception{

    public ServiceLayerException  (String message) {
        super(message);
    }

    public ServiceLayerException (String message, Throwable cause) {
        super(message, cause);
    }


}
