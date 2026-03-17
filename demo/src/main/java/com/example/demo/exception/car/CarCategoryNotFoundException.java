package com.example.demo.exception.car;

public class CarCategoryNotFoundException extends RuntimeException {
    public CarCategoryNotFoundException(String message) {
        super(message);
    }
}
