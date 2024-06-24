package com.dictionary.freeApi.exceptions;

public class ExternalServiceException extends RuntimeException{
    public ExternalServiceException(String message, Throwable cause){
        super(message,cause);
    }
}
