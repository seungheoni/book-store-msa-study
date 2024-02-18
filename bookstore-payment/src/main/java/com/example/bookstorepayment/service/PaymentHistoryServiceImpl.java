package com.example.bookstorepayment.service;

import com.example.bookstorepayment.repository.PaymentHistoryRepository;
import com.example.database.entity.PaymentHistory;
import org.springframework.stereotype.Service;

@Service
public class PaymentHistoryServiceImpl implements PaymentHistoryService {

    private final PaymentHistoryRepository paymentHistoryRepository;

    public PaymentHistoryServiceImpl(PaymentHistoryRepository paymentHistoryRepository) {
        this.paymentHistoryRepository = paymentHistoryRepository;
    }

    @Override
    public Boolean savePaymentHistory(PaymentHistory paymentHistory) {

        try {
            paymentHistoryRepository.save(paymentHistory);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
