package com.example.demo.dto.request;

import com.example.demo.enums.Gearbox;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {

    private String brand;
    private String model;
    private int productionYear;
    private String registrationNumber;
    private String vin;
    private int horsepower;
    private int mileage;
    private Gearbox gearbox;

    private UUID categoryId;
}
