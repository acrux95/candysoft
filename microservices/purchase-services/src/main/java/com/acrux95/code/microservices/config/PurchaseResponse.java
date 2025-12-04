package com.acrux95.code.microservices.config;

import java.math.BigDecimal;
import java.util.List;

public record PurchaseResponse(
        String id,
        String invoiceNumber,
        String supplierId,
        String supplierName,
        String dateCreated,
        String dateUpdated,
        BigDecimal subtotal,
        BigDecimal tax,
        BigDecimal total,
        Boolean active,
        List<PurchaseDetailRequest> details
) {
}
