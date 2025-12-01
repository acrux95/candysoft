package com.acrux95.code.microservices.product_services.configuration;

import com.acrux95.code.microservices.product_services.model.Product;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest request){
        return Product.builder()
                .id(
                        (request.id() == null || request.id().isBlank()
                                ? UUID.randomUUID().toString()
                                : request.id())
                )
                .name(request.name())
                .description(request.description())
                .brand(request.brand())
                .barcode(request.barcode())
                .unit(request.unit())
                .build();
    }

    public ProductResponse toProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .brand(product.getBrand())
                .barcode(product.getBarcode())
                .unit(product.getUnit())
                .dateCreated(product.getDateCreated() != null
                        ? product.getDateCreated().toString()
                        : null)
                .dateUpdated(product.getDateUpdated() != null
                        ? product.getDateUpdated().toString()
                        : null)
                .build();
    }
}
