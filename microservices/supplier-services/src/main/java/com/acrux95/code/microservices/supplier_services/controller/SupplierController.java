package com.acrux95.code.microservices.supplier_services.controller;

import com.acrux95.code.microservices.supplier_services.configuration.SupplierRequest;
import com.acrux95.code.microservices.supplier_services.configuration.SupplierResponse;
import com.acrux95.code.microservices.supplier_services.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/suppliers")
@RequiredArgsConstructor

public class SupplierController {
    private final SupplierService service;

    @PostMapping
    public ResponseEntity<String> createSupplier(@Valid @RequestBody SupplierRequest request){
        return ResponseEntity.ok(service.saveSupplier(request));
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<SupplierResponse> getSuppliersById(@PathVariable ("supplierId") String supplierId){
        return ResponseEntity.ok(service.getSupplierById(supplierId));
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> getSuppliers(){
        return ResponseEntity.ok(service.getSuppliers());
    }

    @PutMapping
    public ResponseEntity<Void> updateSupplier(@Valid @RequestBody SupplierRequest request){
        service.saveSupplier(request);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> disable(@PathVariable ("supplierId") String supplierId){
        service.disableSupplier(supplierId);
        return ResponseEntity.accepted().build();
    }
}
