package com.example.demo.mapper;

import com.example.demo.dto.request.CarCategoryRequest;
import com.example.demo.dto.response.CarCategoryResponse;
import com.example.demo.entity.CarCategory;

public class CategoryCarMapper {

    public static CarCategory mapToCarCategory(CarCategoryRequest carCategoryRequest){

        CarCategory category = new CarCategory();
        category.setName(carCategoryRequest.getName());
        category.setPricePerDay(carCategoryRequest.getPricePerDay());
        return category;
    }

    public static CarCategoryResponse mapToCarCategoryResponse(CarCategory category){
        return CarCategoryResponse.builder()
                .publicId(category.getPublicId())
                .name(category.getName())
                .pricePerDay(category.getPricePerDay())
                .build();
    }
}
