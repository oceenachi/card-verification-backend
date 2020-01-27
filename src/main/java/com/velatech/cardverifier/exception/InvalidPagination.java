package com.velatech.cardverifier.exception;

public class InvalidPagination extends RuntimeException{
    public InvalidPagination(String message) {
        super(message);
    }
}
