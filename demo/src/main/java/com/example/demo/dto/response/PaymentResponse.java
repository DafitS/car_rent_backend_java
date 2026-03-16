package com.example.demo.dto.response;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse {
    private UUID publicId;
    private BigDecimal amount;
    private String status;
    private String method;
    private LocalDateTime paymentDate;
    private RentalResponse rental;
}
