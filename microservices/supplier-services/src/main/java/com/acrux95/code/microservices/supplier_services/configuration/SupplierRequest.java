package com.acrux95.code.microservices.supplier_services.configuration;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record SupplierRequest(
        String id,
        @NotNull(message = "Name is required")
        @NotBlank(message = "Name cannot be blank")
        String name,
        String phoneNumber,
        @Email(message = "Email is not valid")
        String email,
        String address,
        String city,
        String state,
        String country,
        String dateCreated,
        String dateUpdated
) {
}
