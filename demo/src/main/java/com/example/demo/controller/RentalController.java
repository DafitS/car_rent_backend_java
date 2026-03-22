package com.example.demo.controller;

import com.example.demo.dto.request.RentalRequest;
import com.example.demo.dto.response.RentalResponse;
import com.example.demo.service.RentalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@Log4j2
@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @PostMapping
    public ResponseEntity<RentalResponse> createRental(@Valid @RequestBody RentalRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(rentalService.createRental(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalResponse> getRentalById(@PathVariable UUID id) {
        return ResponseEntity.ok(rentalService.getRentalById(id));
    }

    @GetMapping
    public ResponseEntity<List<RentalResponse>> getAllRentals() {
        return ResponseEntity.ok(rentalService.getAllRentals());
    }
}