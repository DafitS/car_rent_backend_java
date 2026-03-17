package com.example.demo.exception;

public class CarCategoryAlreadyExistsException extends RuntimeException {
    public CarCategoryAlreadyExistsException(String message) {
        super(message);
    }
}
