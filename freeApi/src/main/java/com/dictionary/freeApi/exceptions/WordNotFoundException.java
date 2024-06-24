package com.dictionary.freeApi.exceptions;

public class WordNotFoundException extends RuntimeException{
    public WordNotFoundException(String message){
        super(message);
    }
}
