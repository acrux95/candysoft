package com.acrux95.code.microservices.supplier_services.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "suppliers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    @SequenceGenerator(name = "supplier_seq", sequenceName = "supplier_sequence", allocationSize = 1)
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private String country;

    @Column(updatable = false, name = "date_created", columnDefinition = "datetime")
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    @Column(name = "date_updated", columnDefinition = "datetime")
    private LocalDateTime dateUpdated;

    private boolean active = true;
}
