package com.example.bookstorepayment.service;

import com.example.database.entity.PaymentHistory;

public interface PaymentHistoryService {

    Boolean savePaymentHistory(PaymentHistory paymentHistory);
}
