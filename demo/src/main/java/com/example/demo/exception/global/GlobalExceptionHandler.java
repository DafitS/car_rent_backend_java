package com.example.demo.exception.global;

import com.example.demo.exception.PaymentNotFoundException;
import com.example.demo.exception.RentalNotFoundException;
import com.example.demo.exception.car.CarAlreadyExistsException;
import com.example.demo.exception.car.CarCategoryAlreadyExistsException;
import com.example.demo.exception.car.CarCategoryNotFoundException;
import com.example.demo.exception.car.CarNotFoundException;
import com.example.demo.exception.user.UserAlreadyExistsException;
import com.example.demo.exception.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            UserAlreadyExistsException.class,
            CarAlreadyExistsException.class,
            CarCategoryAlreadyExistsException.class
    })
    public ResponseEntity<Object> handleConflict(RuntimeException ex) {
        return buildResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler({
            UserNotFoundException.class,
            CarNotFoundException.class,
            CarCategoryNotFoundException.class,
            RentalNotFoundException.class,
            PaymentNotFoundException.class
    })
    public ResponseEntity<Object> handleNotFound(RuntimeException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobal(Exception ex) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong");
    }

    private ResponseEntity<Object> buildResponse(HttpStatus status, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        return new ResponseEntity<>(body, status);
    }
}