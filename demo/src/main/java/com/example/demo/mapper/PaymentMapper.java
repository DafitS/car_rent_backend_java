package com.example.demo.mapper;

import com.example.demo.dto.request.PaymentRequest;
import com.example.demo.dto.response.PaymentResponse;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Rental;
import com.example.demo.enums.PaymentStatus;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class PaymentMapper {

    public static Payment mapToPayment(PaymentRequest paymentRequest, Rental rental){

        Payment payment = new Payment();
        payment.setRental(rental);
        payment.setAmount(paymentRequest.getAmount());
        payment.setMethod(paymentRequest.getMethod());
        payment.setStatus(PaymentStatus.PENDING);
        payment.setPaymentDate(LocalDateTime.now());
        return payment;
    }

    public static PaymentResponse mapToPaymentResponse(Payment payment){
        return PaymentResponse.builder()
                .publicId(payment.getPublicId())
                .amount(payment.getAmount())
                .status(payment.getStatus().name())
                .method(payment.getMethod().name())
                .paymentDate(payment.getCreatedAt())
                .rental(RentalMapper.mapToRentalResponse(payment.getRental()))
                .build();
    }
}
