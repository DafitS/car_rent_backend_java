package com.example.demo.entity;

import com.example.demo.enums.Gearbox;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity{


    private String brand;
    private String model;
    private int productionYear;

    @Column(unique = true)
    private String registrationNumber;

    private String vin;
    private int horsepower;
    private int mileage;

    @Enumerated(EnumType.STRING)
    private Gearbox gearbox;

    private boolean available = true;

    @Column(nullable = false)
    private boolean active = true;

    @Column
    private LocalDateTime disabledAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CarCategory category;
}
