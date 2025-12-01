package com.acrux95.code.microservices.product_services.configuration;

import lombok.Builder;

@Builder
public record ProductResponse(
        String id,
        String name,
        String description,
        String brand,
        String unit,
        String barcode,
        String dateCreated,
        String dateUpdated
) {
}
