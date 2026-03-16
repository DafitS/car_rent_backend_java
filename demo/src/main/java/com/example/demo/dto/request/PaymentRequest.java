package com.example.demo.dto.request;

import com.example.demo.enums.PaymentMethod;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
    private Long rentalId;
    private BigDecimal amount;
    private PaymentMethod method;
}