package com.example.demo.service.impl;

import com.example.demo.dto.request.CarRequest;
import com.example.demo.dto.response.CarResponse;
import com.example.demo.entity.Car;
import com.example.demo.entity.CarCategory;
import com.example.demo.exception.CarAlreadyExistsException;
import com.example.demo.exception.CarCategoryNotFoundException;
import com.example.demo.exception.CarNotFoundException;
import com.example.demo.mapper.CarMapper;
import com.example.demo.repository.CarCategoryRepository;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.RentalRepository;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarCategoryRepository carCategoryRepository;
    private final RentalRepository rentalRepository;

    @Override
    public CarResponse createCar(CarRequest carRequest) {

        CarCategory carCategory = carCategoryRepository
                .findByPublicId(carRequest.getCategoryId())
                .orElseThrow(() -> new CarCategoryNotFoundException("Category Not Exists!!!"));

        if(carRepository.existsByRegistrationNumber(carRequest.getRegistrationNumber()))
        {
            throw new CarAlreadyExistsException("This Car Already Exists!!!");
        }

        Car car = CarMapper.mapToCar(carRequest, carCategory);
        Car savedCar = carRepository.save(car);

        return CarMapper.mapToCarResponse(savedCar);
    }

    @Override
    public CarResponse getCarByPublicId(UUID id) {

        Car foundCar = carRepository
                .findByPublicId(id)
                .orElseThrow(() -> new CarNotFoundException("Car Not Found"));

        return CarMapper.mapToCarResponse(foundCar);
    }

    @Override
    public List<CarResponse> getAllCars() {

        List<CarResponse> allCars = carRepository.findAll()
                .stream()
                .map(CarMapper::mapToCarResponse)
                .toList();

        return allCars;
    }

    @Override
    public List<CarResponse> getCars() {
        List<CarResponse> allActiveCars = carRepository
                .findAllByActiveTrue()
                .stream()
                .map(CarMapper::mapToCarResponse)
                .toList();

        return allActiveCars;
    }

    @Override
    public CarResponse updateCar(UUID id, CarRequest request) {

        Car car = carRepository.findByPublicId(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found"));

        CarCategory category = carCategoryRepository.findByPublicId(request.getCategoryId())
                .orElseThrow(() -> new CarCategoryNotFoundException("Category not found"));

        if (!car.getRegistrationNumber().equals(request.getRegistrationNumber()) &&
                carRepository.existsByRegistrationNumber(request.getRegistrationNumber())) {
            throw new CarAlreadyExistsException("Registration number already exists");
        }

        car.setBrand(request.getBrand());
        car.setModel(request.getModel());
        car.setProductionYear(request.getProductionYear());
        car.setRegistrationNumber(request.getRegistrationNumber());
        car.setVin(request.getVin());
        car.setHorsepower(request.getHorsepower());
        car.setMileage(request.getMileage());
        car.setGearbox(request.getGearbox());
        car.setCategory(category);

        Car updatedCar = carRepository.save(car);

        return CarMapper.mapToCarResponse(updatedCar);
    }

    @Override
    public void deleteCar(UUID id) {

        Car car = carRepository.findByPublicId(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found!!!"));

        car.setActive(false);
        car.setDisabledAt(LocalDateTime.now());
        carRepository.save(car);
    }

    @Override
    public List<CarResponse> getAvailableCars() {
        List<CarResponse> allAvailableCars = carRepository.findAllByAvailableTrue()
                .stream()
                .map(CarMapper::mapToCarResponse)
                .toList();

        return allAvailableCars;
    }

    @Override
    public List<CarResponse> getCarsByCategory(UUID categoryId) {
        return carRepository.findAllByCategoryIdAndActiveTrue(categoryId)
                .stream()
                .map(CarMapper::mapToCarResponse)
                .toList();
    }

    @Override
    public boolean checkAvailability(UUID carId, LocalDate startDate, LocalDate endDate) {

        if (!carRepository.existsByPublicId(carId)) {
            throw new CarNotFoundException("Car not found");
        }

        boolean exists = rentalRepository
                .existsByCarIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                        carId,
                        endDate,
                        startDate
                );

        return !exists;
    }
}
