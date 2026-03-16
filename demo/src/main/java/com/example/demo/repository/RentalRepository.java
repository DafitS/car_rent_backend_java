package com.example.demo.repository;

import com.example.demo.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface RentalRepository extends JpaRepository <Rental, Long> {

    boolean existsByCarIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            UUID carId,
            LocalDate endDate,
            LocalDate startDate
    );
}
