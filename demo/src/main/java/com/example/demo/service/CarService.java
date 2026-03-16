package com.example.demo.service;

import com.example.demo.dto.request.CarRequest;
import com.example.demo.dto.response.CarResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface CarService {

    CarResponse createCar(CarRequest carRequest);

    CarResponse getCarByPublicId(UUID id);

    List<CarResponse> getAllCars();

    List<CarResponse> getCars();

    CarResponse updateCar(UUID id, CarRequest request);

    void deleteCar(UUID id);

    List<CarResponse> getAvailableCars();

    List<CarResponse> getCarsByCategory(UUID categoryId);

    boolean checkAvailability(UUID carId, LocalDate startDate, LocalDate endDate);
}
