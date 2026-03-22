package com.example.demo.controller;

import com.example.demo.dto.request.CarCategoryRequest;
import com.example.demo.dto.response.CarCategoryResponse;
import com.example.demo.service.CarCategoryService;
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
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CarCategoryController {

    private final CarCategoryService carCategoryService;

    @PostMapping
    public ResponseEntity<CarCategoryResponse> createCategory(@Valid @RequestBody CarCategoryRequest request) {
        CarCategoryResponse response = carCategoryService.createCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarCategoryResponse> getCategoryById(@PathVariable UUID id) {
        return ResponseEntity.ok(carCategoryService.getCategoryById(id));
    }

    @GetMapping
    public ResponseEntity<List<CarCategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(carCategoryService.getAllCategories());
    }
}