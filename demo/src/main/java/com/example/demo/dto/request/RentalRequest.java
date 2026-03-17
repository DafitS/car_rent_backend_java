package com.example.demo.dto.request;

import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalRequest {

    private UUID carId;
    private UUID userId;
    private LocalDate startDate;
    private LocalDate endDate;
}