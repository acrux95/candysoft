package com.acrux95.code.microservices.supplier_services.repository;

import com.acrux95.code.microservices.supplier_services.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {

    List<Supplier> findAllByActiveTrue();

    Optional<Supplier> findByIdAndActiveTrue(String id);
}
