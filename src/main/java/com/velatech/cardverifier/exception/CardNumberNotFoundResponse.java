package com.velatech.cardverifier.exception;

import lombok.Data;

@Data
public class CardNumberNotFoundResponse {

    private String message;

    CardNumberNotFoundResponse(String message){
        this.message = message;
    }
}
