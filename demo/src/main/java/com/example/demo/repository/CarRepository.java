package com.example.demo.repository;

import com.example.demo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarRepository extends JpaRepository <Car, Long> {

    boolean existsByRegistrationNumber(String registrationNumber);

    boolean existsByPublicId(UUID id);

    Optional<Car> findByPublicId(UUID publicId);

    List<Car> findAllByActiveTrue();

    List<Car> findAllByAvailableTrue();

    List<Car> findAllByCategoryIdAndActiveTrue(UUID categoryId);

}
