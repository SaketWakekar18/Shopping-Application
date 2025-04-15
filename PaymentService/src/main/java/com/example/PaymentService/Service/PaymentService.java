package com.example.PaymentService.Service;

import com.example.PaymentService.Model.PaymentRequest;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);
}
