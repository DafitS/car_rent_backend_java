package com.example.demo.repository;

import com.example.demo.entity.CarCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarCategoryRepository extends JpaRepository <CarCategory, Long> {

    Optional<CarCategory> findByPublicId(UUID publicId);

    boolean existsByName(String name);
}
