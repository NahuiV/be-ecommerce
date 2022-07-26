package com.be.ecommerce.controllers;


import com.be.ecommerce.dto.SupplierDTO;
import com.be.ecommerce.entities.Supplier;
import com.be.ecommerce.mappers.SupplierMapper;
import com.be.ecommerce.services.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    private final SupplierMapper supplierMapper;

    public SupplierController(SupplierService supplierService, SupplierMapper supplierMapper){

        this.supplierService = supplierService;
        this.supplierMapper = supplierMapper;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SupplierDTO getSupplier(@PathVariable("id") Long id){

        Supplier supplier = supplierService.getSupplier(id);
        return supplierMapper.converToDTO(supplier);
    }

}
