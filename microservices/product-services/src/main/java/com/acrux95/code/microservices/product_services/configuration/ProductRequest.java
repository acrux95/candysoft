package com.acrux95.code.microservices.product_services.configuration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
        String id,
        @NotNull(message = "Name is requiered")
        @NotBlank(message = "Name cannot be blank")
        String name,
        @NotNull(message = "Description is requiered")
        @NotBlank(message = "Description cannot be blank")
        String description,
        @NotNull(message = "Brand is requiered")
        @NotBlank(message = "Brand cannot be blank")
        String brand,
        @NotNull(message = "Unit is requiered")
        @NotBlank(message = "Unit cannot be blank")
        String unit,
        String barcode,
        String dateCreated,
        String dateUpdated
) {
}
