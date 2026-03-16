package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "car_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarCategory extends BaseEntity {

    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerDay;

    private String description;
}
