package com.microservices.ProductService.Service;

import com.microservices.ProductService.Entity.Product;
import com.microservices.ProductService.Model.ProductRequest;
import com.microservices.ProductService.Model.ProductResponse;

public interface ProductService {
    public long addProduct(ProductRequest productRequest);

    public ProductResponse getProducyById(long productId);

    public void reduceQuantity(long productId, long quantity);
}
