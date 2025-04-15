package com.microservices.OrderService.Service;

import com.microservices.OrderService.Entity.Order;
import com.microservices.OrderService.External.Clients.ProductService;
import com.microservices.OrderService.Model.OrderRequest;
import com.microservices.OrderService.Repositiory.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.logging.Logger;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;
    private static final Logger logger = Logger.getLogger(OrderServiceImpl.class.getName());

    @Override
    public long placeOrder(OrderRequest orderRequest) {

        productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());

        logger.info("Placing Order Request " + orderRequest);
        Order order = new Order(orderRequest.getProductId(), orderRequest.getQuantity(), Instant.now(),"CREATED",orderRequest.getAmount());
        orderRepository.save(order);
        logger.info("Order Added successfully with order ID: "+ order.getOrderId());
        return order.getOrderId();
    }
}
