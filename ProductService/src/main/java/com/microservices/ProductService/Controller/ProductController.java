package com.microservices.ProductService.Controller;

import com.microservices.ProductService.Entity.Product;
import com.microservices.ProductService.Model.ProductRequest;
import com.microservices.ProductService.Model.ProductResponse;
import com.microservices.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Long> addProducts(@RequestBody ProductRequest productRequest){
        long productId = productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long id){
        ProductResponse product = productService.getProducyById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
