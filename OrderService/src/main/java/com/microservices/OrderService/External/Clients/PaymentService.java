package com.microservices.OrderService.External.Clients;

import com.microservices.OrderService.External.Request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PaymentService/payment")
public interface PaymentService {
    @PostMapping("/pay")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);
}
