package com.microservices.OrderService.Service;

import com.microservices.OrderService.Model.OrderRequest;

public interface OrderService {
    public long placeOrder(OrderRequest orderRequest);
}
