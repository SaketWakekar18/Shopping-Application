package com.microservices.OrderService.Exception;

import com.microservices.OrderService.External.Response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception) {
        ErrorResponse response = new ErrorResponse(exception.getMessage(), exception.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(exception.getStatus()));
    }
}
