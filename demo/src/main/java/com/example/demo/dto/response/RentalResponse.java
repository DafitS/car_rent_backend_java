package com.example.demo.dto.response;

import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalResponse {

    private UUID publicId;
    private UUID carId;
    private UUID userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}