package com.example.demo.exception.car;

public class CarCategoryAlreadyExistsException extends RuntimeException {
    public CarCategoryAlreadyExistsException(String message) {
        super(message);
    }
}
