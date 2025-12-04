package com.acrux95.code.microservices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "purchases")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Purchase {
    @Id
    private String id;
    private String invoiceNumber;
    private String supplierId;
    private String supplierName;
    private BigDecimal subtotal;
    private BigDecimal total;

    @Transient
    private final double tax = 0.15;

    @Column(updatable = false, name = "date_created")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name = "date_updated")
    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    @Builder.Default
    private Boolean active = true;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase", orphanRemoval = true)
    private List<PurchaseDetail> purchaseDetails = new ArrayList<>();
}
