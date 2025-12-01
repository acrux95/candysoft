package com.acrux95.code.microservices.product_services.service;

import com.acrux95.code.microservices.product_services.configuration.ProductMapper;
import com.acrux95.code.microservices.product_services.configuration.ProductRequest;
import com.acrux95.code.microservices.product_services.configuration.ProductResponse;
import com.acrux95.code.microservices.product_services.model.Product;
import com.acrux95.code.microservices.product_services.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public String saveProduct(ProductRequest request) {

        var product = repository.save(mapper.toProduct(request));
        return product.getId();
    }

    public ProductResponse getProductById(String productId) {
        return repository
                .findByIdAndActiveTrue(productId)
                .map(mapper::toProductResponse)
                .orElse(null);
    }

    public List<ProductResponse> getProducts() {
        return repository.findAllByActiveTrue().stream()
                .map(mapper::toProductResponse)
                .toList();
    }

    public void updateProduct(String productId,ProductRequest request) {
        Product product = repository.findById(productId)
                .orElseThrow(()-> new RuntimeException("product not found"));
        product.setName(request.name());
        product.setDescription(request.description());
        product.setBarcode(request.barcode());
        product.setUnit(request.unit());

        repository.save(product);
    }
    public void disableProduct(String productId) {
        Product product = repository.findById(productId)
                .orElseThrow(()-> new RuntimeException("product not found"));
        product.setActive(false);
        repository.save(product);
    }

}
