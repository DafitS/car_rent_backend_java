package com.example.demo.exception;

public class CarCategoryNotFoundException extends RuntimeException {
    public CarCategoryNotFoundException(String message) {
        super(message);
    }
}
