package com.acrux95.code.microservices.product_services.controller;

import com.acrux95.code.microservices.product_services.configuration.ProductRequest;
import com.acrux95.code.microservices.product_services.configuration.ProductResponse;
import com.acrux95.code.microservices.product_services.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductRequest request){
        return ResponseEntity.ok(service.saveProduct(request));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductsById(@PathVariable ("productId") String productId){
        return ResponseEntity.ok(service.getProductById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts(){
        return ResponseEntity.ok(service.getProducts());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable String productId, @Valid @RequestBody ProductRequest request){
        service.updateProduct(productId, request);
        return ResponseEntity.ok("Product " + productId +" updated successfully");
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> disable(@PathVariable ("productId") String productId){
        service.disableProduct(productId);
        return ResponseEntity.ok("Product " + productId +" disabled successfully");
    }
}
