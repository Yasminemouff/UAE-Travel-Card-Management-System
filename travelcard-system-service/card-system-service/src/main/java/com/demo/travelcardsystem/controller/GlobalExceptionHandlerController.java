package com.demo.travelcardsystem.controller;

import com.demo.travelcardsystem.exception.InvalidCardException;
import com.demo.travelcardsystem.exception.InvalidDataProvidedException;
import com.demo.travelcardsystem.exception.InvalidRechargeAmount;
import com.demo.travelcardsystem.exception.TravelCardException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler({InvalidCardException.class, InvalidRechargeAmount.class})
    public ResponseEntity<String> handleInvalidRequestException(TravelCardException invalidCardException) {
        invalidCardException.printStackTrace();
        return new ResponseEntity<>(invalidCardException.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidDataProvidedException.class)
    public ResponseEntity<String> handleInvalidDataProvidedException(InvalidDataProvidedException invalidDataProvidedException) {
        invalidDataProvidedException.printStackTrace();
        return new ResponseEntity<>("Invalid request! Please check input", HttpStatus.BAD_REQUEST);
    }
}