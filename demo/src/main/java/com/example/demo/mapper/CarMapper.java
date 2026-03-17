package com.example.demo.mapper;

import com.example.demo.dto.request.CarRequest;
import com.example.demo.dto.response.CarResponse;
import com.example.demo.entity.Car;
import com.example.demo.entity.CarCategory;

public class CarMapper {

    public static Car mapToCar(CarRequest carRequest, CarCategory carCategory){
        Car car = new Car();
        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        car.setProductionYear(carRequest.getProductionYear());
        car.setRegistrationNumber(carRequest.getRegistrationNumber());
        car.setVin(carRequest.getVin());
        car.setHorsepower(carRequest.getHorsepower());
        car.setMileage(carRequest.getMileage());
        car.setGearbox(carRequest.getGearbox());
        car.setCategory(carCategory);
        return car;
    }

    public static CarResponse mapToCarResponse(Car car){
        return CarResponse.builder()
                .publicId(car.getPublicId())
                .brand(car.getBrand())
                .model(car.getModel())
                .productionYear(car.getProductionYear())
                .registrationNumber(car.getRegistrationNumber())
                .vin(car.getVin())
                .horsepower(car.getHorsepower())
                .mileage(car.getMileage())
                .gearbox(car.getGearbox().name())
                .available(car.isAvailable())
                .categoryName(car.getCategory().getName())
                .categoryPricePerDay(car.getCategory().getPricePerDay())
                .build();
    }
}
