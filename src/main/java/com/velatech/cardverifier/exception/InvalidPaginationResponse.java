package com.velatech.cardverifier.exception;


import lombok.Data;

@Data
public class InvalidPaginationResponse {

    private String message;

    public InvalidPaginationResponse(String message) {
        this.message = message;
    }
}
