package com.microservices.OrderService.External.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ProductService/products")
public interface ProductService {
    @PutMapping("/update/{id}")
    ResponseEntity<Void> reduceQuantity(@PathVariable("id") long id, @RequestParam long quantity);
}
