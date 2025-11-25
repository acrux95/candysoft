package com.acrux95.code.microservices.supplier_services.configuration;

import com.acrux95.code.microservices.supplier_services.model.Supplier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SupplierMapper {
    public Supplier toSupplier(SupplierRequest request) {
        return Supplier.builder()
                .id(
                        (request.id() == null || request.id().isBlank()
                            ? UUID.randomUUID().toString()
                            : request.id())
                )
                .name(request.name())
                .phoneNumber(request.phoneNumber())
                .email(request.email())
                .address(request.address())
                .city(request.city())
                .state(request.state())
                .country(request.country())
                .dateCreated(LocalDateTime.parse(request.dateCreated()))
                .dateUpdated(LocalDateTime.parse(request.dateUpdated()))
                .build();
    }

    public SupplierResponse toSupplierResponse(Supplier supplier){
        return SupplierResponse.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .phoneNumber(supplier.getPhoneNumber())
                .email(supplier.getEmail())
                .address(supplier.getAddress())
                .city(supplier.getCity())
                .state(supplier.getState())
                .country(supplier.getCountry())
                .dateCreated(String.valueOf(supplier.getDateCreated()))
                .dateUpdated(String.valueOf(supplier.getDateUpdated()))
                .build();
    }
}
