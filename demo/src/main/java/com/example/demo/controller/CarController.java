package com.example.demo.controller;

import com.example.demo.dto.request.CarRequest;
import com.example.demo.dto.response.CarResponse;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Log4j2
@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<CarResponse> createCar(@Valid @RequestBody CarRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(carService.createCar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> getCarById(@PathVariable UUID id) {
        return ResponseEntity.ok(carService.getCarByPublicId(id));
    }

    @GetMapping
    public ResponseEntity<List<CarResponse>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/active")
    public ResponseEntity<List<CarResponse>> getActiveCars() {
        return ResponseEntity.ok(carService.getCars());
    }

    @GetMapping("/available")
    public ResponseEntity<List<CarResponse>> getAvailableCars() {
        return ResponseEntity.ok(carService.getAvailableCars());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<CarResponse>> getCarsByCategory(@PathVariable UUID categoryId) {
        return ResponseEntity.ok(carService.getCarsByCategory(categoryId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarResponse> updateCar(
            @PathVariable UUID id,
            @Valid @RequestBody CarRequest request) {

        return ResponseEntity.ok(carService.updateCar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable UUID id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build(); // 204
    }

    @GetMapping("/{id}/availability")
    public ResponseEntity<Boolean> checkAvailability(
            @PathVariable UUID id,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {

        return ResponseEntity.ok(
                carService.checkAvailability(id, startDate, endDate)
        );
    }
}