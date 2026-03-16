package com.example.demo.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarCategoryRequest {

    private String name;
    private BigDecimal pricePerDay;
}