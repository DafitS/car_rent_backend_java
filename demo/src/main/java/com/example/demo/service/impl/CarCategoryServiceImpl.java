package com.example.demo.service.impl;

import com.example.demo.dto.request.CarCategoryRequest;
import com.example.demo.dto.response.CarCategoryResponse;
import com.example.demo.entity.CarCategory;
import com.example.demo.exception.CarCategoryAlreadyExistsException;
import com.example.demo.exception.CarCategoryNotFoundException;
import com.example.demo.mapper.CategoryCarMapper;
import com.example.demo.repository.CarCategoryRepository;
import com.example.demo.service.CarCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarCategoryServiceImpl implements CarCategoryService {

    private final CarCategoryRepository carCategoryRepository;


    @Override
    public CarCategoryResponse createCategory(CarCategoryRequest request) {
        if (carCategoryRepository.existsByName(request.getName())) {
            throw new CarCategoryAlreadyExistsException("Category already exists!");
        }

        CarCategory category = CategoryCarMapper.mapToCarCategory(request);
        CarCategory saved = carCategoryRepository.save(category);

        return CategoryCarMapper.mapToCarCategoryResponse(saved);
    }

    @Override
    public CarCategoryResponse getCategoryById(UUID id) {
        CarCategory category = carCategoryRepository.findByPublicId(id)
                .orElseThrow(() -> new CarCategoryNotFoundException("Category not found!"));

        return CategoryCarMapper.mapToCarCategoryResponse(category);
    }

    @Override
    public List<CarCategoryResponse> getAllCategories() {
        return carCategoryRepository.findAll()
                .stream()
                .map(CategoryCarMapper::mapToCarCategoryResponse)
                .toList();
    }
}
