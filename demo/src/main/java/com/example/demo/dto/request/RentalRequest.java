package com.example.demo.dto.request;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalRequest {

    private Long carId;
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
}