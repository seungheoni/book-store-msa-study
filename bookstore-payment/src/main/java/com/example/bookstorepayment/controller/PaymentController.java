package com.example.bookstorepayment.controller;

import com.example.bookstorepayment.repository.PaymentHistoryRepository;
import com.example.database.entity.PaymentHistory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentHistoryRepository paymentHistoryRepository;

    public PaymentController(PaymentHistoryRepository paymentHistoryRepository) {
        this.paymentHistoryRepository = paymentHistoryRepository;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createPaymentHistory(@RequestBody PaymentHistory paymentHistory) {
        paymentHistoryRepository.save(paymentHistory);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
