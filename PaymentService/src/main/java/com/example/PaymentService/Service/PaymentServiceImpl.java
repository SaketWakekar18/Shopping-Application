package com.example.PaymentService.Service;

import com.example.PaymentService.Entity.TransactionDetails;
import com.example.PaymentService.Model.PaymentRequest;
import com.example.PaymentService.Repository.TransactionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.logging.Logger;

@Service
public class PaymentServiceImpl implements PaymentService{
    private static final Logger logger = Logger.getLogger(PaymentServiceImpl.class.getName());

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;
    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        logger.info("Recording payment Details: "+ paymentRequest);
        TransactionDetails details = new TransactionDetails(paymentRequest.getOrderId(),paymentRequest.getPaymentModes().name(),paymentRequest.getReferenceNumber(), Instant.now(),"SUCCESS",paymentRequest.getAmount());
        transactionDetailsRepository.save(details);
        logger.info("Transaction Completed with ID: "+details.getId());
        return details.getId();
    }
}
