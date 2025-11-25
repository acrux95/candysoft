package com.acrux95.code.microservices.supplier_services.configuration;

import lombok.Builder;

@Builder
public record SupplierResponse(
        String id,
        String name,
        String phoneNumber,
        String email,
        String address,
        String city,
        String state,
        String country,
        String dateCreated,
        String dateUpdated
) {
}
