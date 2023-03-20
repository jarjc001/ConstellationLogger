package com.ConstellationLogger.dao;

public class DataBaseException extends Exception{

    public DataBaseException  (String message) {
        super(message);
    }

    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }


}
