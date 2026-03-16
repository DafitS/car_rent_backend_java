package com.example.demo.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarResponse {

    private UUID publicId;
    private String brand;
    private String model;
    private int productionYear;
    private String registrationNumber;
    private String vin;
    private int horsepower;
    private int mileage;
    private String gearbox;
    private boolean available;

    private String categoryName;
    private BigDecimal categoryPricePerDay;
}
