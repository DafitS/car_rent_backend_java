package com.example.demo.service.impl;

import com.example.demo.dto.request.RentalRequest;
import com.example.demo.dto.response.RentalResponse;
import com.example.demo.entity.Car;
import com.example.demo.entity.Rental;
import com.example.demo.entity.User;
import com.example.demo.exception.CarNotFoundException;
import com.example.demo.exception.RentalNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.RentalMapper;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.RentalRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public RentalResponse createRental(RentalRequest rentalRequest) {

        Car car = carRepository.findByPublicId(rentalRequest.getCarId())
                .orElseThrow(() -> new CarNotFoundException("Car not found"));

        User user = userRepository.findByPublicId(rentalRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Rental rental = RentalMapper.mapToRental(rentalRequest, car, user);

        Rental savedRental = rentalRepository.save(rental);

        return RentalMapper.mapToRentalResponse(savedRental);
    }

    @Transactional(readOnly = true)
    @Override
    public RentalResponse getRentalById(UUID id) {
        Rental rental = rentalRepository.findByPublicId(id)
                .orElseThrow(() -> new RentalNotFoundException("Rental not found"));
        return RentalMapper.mapToRentalResponse(rental);
    }

    @Transactional(readOnly = true)
    @Override
    public List<RentalResponse> getAllRentals() {
        return rentalRepository.findAll()
                .stream()
                .map(RentalMapper::mapToRentalResponse)
                .toList();
    }
}
