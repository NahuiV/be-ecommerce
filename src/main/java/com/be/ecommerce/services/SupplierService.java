package com.be.ecommerce.services;


import com.be.ecommerce.constants.Constants;
import com.be.ecommerce.entities.Supplier;
import com.be.ecommerce.exceptions.supplier.SupplierNotFoundException;
import com.be.ecommerce.repositories.SupplierRepository;
import com.be.ecommerce.exceptions.supplier.SupplierExistsException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository){

        this.supplierRepository = supplierRepository;

    }

    public void addSupplier(Supplier supplier){

        Optional<Supplier> optionalSupplier = supplierRepository.findSupplierByEmail(supplier.getEmail());
        if(optionalSupplier.isPresent()){

            throw new SupplierExistsException(Constants.SUPPLIER_EXISTS + supplier.getEmail());

        }
        supplierRepository.save(supplier);

    }

    public void deletSupplie(Long id){

        if(!supplierRepository.existsById(id)){

            throw new SupplierNotFoundException(Constants.SUPPLIER_NOT_FOUND + id);

        }
        supplierRepository.deleteById(id);

    }

    public Supplier getSupplier(Long id){

        Optional<Supplier> supplier = supplierRepository.findById(id);
        if(!supplier.isPresent()){

            throw new SupplierNotFoundException(Constants.SUPPLIER_NOT_FOUND + id);

        }

        return supplier.get();

    }

    public void saveSupplier(Supplier supplier){

        supplierRepository.save(supplier);

    }

    public List<Supplier> getAllSuppliers(){ return supplierRepository.findAll();}

}
