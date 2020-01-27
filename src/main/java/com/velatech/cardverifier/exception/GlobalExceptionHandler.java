package com.velatech.cardverifier.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleCardNumberNotFound(CardNumberNotFound ex) {
        CardNumberNotFoundResponse exceptionResponse = new CardNumberNotFoundResponse(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public final ResponseEntity<Object> handleInvalidPagination(InvalidPagination ex) {
        InvalidPaginationResponse exceptionResponse = new InvalidPaginationResponse(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleRecordNotFoundException(recordNotFoundException ex) {
        recordNotFoundResponse exceptionResponse = new recordNotFoundResponse(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
