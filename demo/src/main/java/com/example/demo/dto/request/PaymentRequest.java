package com.example.demo.dto.request;

import com.example.demo.enums.PaymentMethod;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
    private UUID rentalId;
    private BigDecimal amount;
    private PaymentMethod method;
}