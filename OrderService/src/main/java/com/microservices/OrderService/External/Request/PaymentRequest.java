package com.microservices.OrderService.External.Request;

import com.microservices.OrderService.Model.PaymentModes;

public class PaymentRequest {
    private long orderId;
    private long amount;
    private String referenceNumber;
    private PaymentModes paymentModes;

    public PaymentRequest(long orderId, PaymentModes paymentModes, long amount) {
        this.orderId = orderId;
        this.paymentModes = paymentModes;
        this.amount = amount;
    }


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public PaymentModes getPaymentModes() {
        return paymentModes;
    }

    public void setPaymentModes(PaymentModes paymentModes) {
        this.paymentModes = paymentModes;
    }
}
