package com.example.demo.service;

import com.example.demo.dto.request.RentalRequest;
import com.example.demo.dto.response.RentalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface RentalService {

    RentalResponse createRental(RentalRequest rentalRequest);

    RentalResponse getRentalById(UUID id);

    List<RentalResponse> getAllRentals();
}
