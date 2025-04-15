package com.microservices.ProductService.Service;

import com.microservices.ProductService.Entity.Product;
import com.microservices.ProductService.Exceptions.ProductNotFoundException;
import com.microservices.ProductService.Model.ProductRequest;
import com.microservices.ProductService.Model.ProductResponse;
import com.microservices.ProductService.Repository.ProductRepository;

import java.util.logging.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = Logger.getLogger(ProductServiceImpl.class.getName());
    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        logger.info("Adding product");
        Product product = new Product(
                productRequest.getProductName(),
                productRequest.getPrice(),
                productRequest.getQuantity()
        );
        productRepository.save(product);
        logger.info("Product Added successfully");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProducyById(long productId) {
        logger.info("Fetching product with ID: " + productId);
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product with given ID not found","PRODUCT NOT FOUND"));
        ProductResponse response = new ProductResponse();
//        response.setProductId(product.getProductId());
//        response.setProductName(product.getProductName());
//        response.setPrice(product.getPrice());
//        response.setQuantity(product.getQuantity());
        BeanUtils.copyProperties(product, response);
        return response;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        logger.info("Reduce quantity for product ID: "+ productId +" and quantity: "+quantity);
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product with given ID not found", "PRODUCT NOT FOUND"));
        if(product.getQuantity()<quantity){
            throw new ProductNotFoundException("Product does not have sufficient Quantity", "INSUFFICIENT QUANTITY");
        }
        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
        logger.info("Product Updated Successfully");
    }
}
