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

@Entity
@Table(name = "purchase_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PurchaseDetail {
    @Id
    private String id;
    private String productId;
    private String productName;
    private String productDescription;
    private String unit;

    private int quantity;

    private BigDecimal unitPrice;
    private BigDecimal total;

    @CreationTimestamp
    @Column(updatable = false, name = "date_created")
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;

    @Builder.Default
    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
}
