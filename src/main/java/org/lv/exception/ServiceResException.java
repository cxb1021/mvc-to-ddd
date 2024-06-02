package org.lv.exception;

public class ServiceResException extends RuntimeException{
    private String message;

    public ServiceResException(String message) {
        this.message = message;
    }
}
