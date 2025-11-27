package com.acrux95.code.microservices.supplier_services.service;

import com.acrux95.code.microservices.supplier_services.configuration.SupplierMapper;
import com.acrux95.code.microservices.supplier_services.configuration.SupplierRequest;
import com.acrux95.code.microservices.supplier_services.configuration.SupplierResponse;
import com.acrux95.code.microservices.supplier_services.model.Supplier;
import com.acrux95.code.microservices.supplier_services.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository repository;
    private final SupplierMapper mapper;

    public String saveSupplier(SupplierRequest request) {

        var supplier = repository.save(mapper.toSupplier(request));
        return supplier.getId();
    }

    public SupplierResponse getSupplierById(String supplierId) {
        return repository
                .findByIdAndActiveTrue(supplierId)
                .map(mapper::toSupplierResponse)
                .orElse(null);
    }

    public List<SupplierResponse> getSuppliers() {
        return repository.findAllByActiveTrue().stream()
                .map(mapper::toSupplierResponse)
                .toList();
    }

    public void updateSupplier(String supplierId, SupplierRequest request){
        Supplier supplier = repository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        supplier.setName(request.name());
        supplier.setPhoneNumber(request.phoneNumber());
        supplier.setEmail(request.email());
        supplier.setAddress(request.address());
        supplier.setCity(request.city());
        supplier.setState(request.state());
        supplier.setCountry(request.country());

        repository.save(supplier);
    }

    public void disableSupplier(String supplierId) {
        Supplier supplier = repository.findById(supplierId)
                .orElseThrow(()->new RuntimeException("supplier not found"));
        supplier.setActive(false);
        repository.save(supplier);
    }


}
