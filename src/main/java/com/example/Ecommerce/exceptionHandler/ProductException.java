package com.example.Ecommerce.exceptionHandler;

public class ProductException extends Exception{
    private static final Integer id = 1;

    private String errorMessage;

    public ProductException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
