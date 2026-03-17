package com.example.demo.service;

import com.example.demo.dto.request.CarCategoryRequest;
import com.example.demo.dto.response.CarCategoryResponse;

import java.util.List;
import java.util.UUID;

public interface CarCategoryService {

    CarCategoryResponse createCategory(CarCategoryRequest request);

    CarCategoryResponse getCategoryById(UUID id);

    List<CarCategoryResponse> getAllCategories();
}
