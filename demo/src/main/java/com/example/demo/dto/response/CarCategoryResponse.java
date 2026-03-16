package com.example.demo.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarCategoryResponse {

    private UUID publicId;
    private String name;
    private BigDecimal pricePerDay;
}