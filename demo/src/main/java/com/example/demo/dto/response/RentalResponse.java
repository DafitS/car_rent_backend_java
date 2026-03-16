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
    private CarResponse car;
    private UserResponse user;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}