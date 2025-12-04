package com.acrux95.code.microservices.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PurchaseRequest(
        String id,
        @NotNull(message = "Invoice Number is required")
        @NotBlank(message = "Invoice Number cannot be blank")
        String invoiceNumber,
        @NotNull(message = "Supplier Id is required")
        @NotBlank(message = "Supplier Id cannot be blank")
        String supplierId,
        @NotNull(message = "First name is required")
        @NotBlank(message = "First name cannot be blank")
        String supplierName,
        String dateCreated,
        String dateUpdated,
        List<PurchaseDetailRequest> details
) {
}
