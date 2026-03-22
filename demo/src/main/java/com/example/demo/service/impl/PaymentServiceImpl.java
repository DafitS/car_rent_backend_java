package com.example.demo.service.impl;

import com.example.demo.dto.request.PaymentRequest;
import com.example.demo.dto.response.PaymentResponse;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Rental;
import com.example.demo.enums.PaymentStatus;
import com.example.demo.exception.PaymentNotFoundException;
import com.example.demo.exception.RentalNotFoundException;
import com.example.demo.mapper.PaymentMapper;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.RentalRepository;
import com.example.demo.service.PaymentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final RentalRepository rentalRepository;

    @Override
    public PaymentResponse createPayment(PaymentRequest request) {

        Rental rental = rentalRepository.findByPublicId(request.getRentalId())
                .orElseThrow(() -> new RentalNotFoundException("Rental not found!"));

        Payment payment = PaymentMapper.mapToPayment(request, rental);

        payment.setStatus(
                (request.getAmount().compareTo(rental.getTotalPrice()) < 0)?
                        PaymentStatus.FAILED:
                            PaymentStatus.PENDING
        );


        Payment saved = paymentRepository.save(payment);

        if(payment.getStatus() == PaymentStatus.FAILED){
            rental.setPaymentFailed(true);
            rentalRepository.save(rental);
        }

        return PaymentMapper.mapToPaymentResponse(saved);
    }

    @Transactional
    @Override
    public PaymentResponse getPaymentById(UUID id) {
        Payment payment = paymentRepository.findByPublicId(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found!"));

        return PaymentMapper.mapToPaymentResponse(payment);
    }

    @Transactional
    @Override
    public List<PaymentResponse> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(PaymentMapper::mapToPaymentResponse)
                .toList();
    }
}