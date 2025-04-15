package com.microservices.ProductService.Exceptions;

public class ProductNotFoundException extends RuntimeException{
    private String message;
    private String errorCode;

    public ProductNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}
