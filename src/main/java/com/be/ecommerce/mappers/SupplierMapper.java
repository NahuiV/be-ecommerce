package com.be.ecommerce.mappers;

import com.be.ecommerce.dto.SupplierDTO;
import com.be.ecommerce.entities.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

    private final ModelMapper supplierMapper;

    public SupplierMapper(){this.supplierMapper = new ModelMapper();}

    public SupplierDTO converToDTO(Supplier supplier){

        SupplierDTO supplierDTO = supplierMapper.map(supplier, SupplierDTO.class);
        return supplierDTO;

    }

    public Supplier converToEntity(SupplierDTO supplierDTO){

        Supplier supplier = supplierMapper.map(supplierDTO, Supplier.class);
        return supplier;

    }

}
