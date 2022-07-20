package com.be.ecommerce.mappers;

import com.be.ecommerce.dto.ShipperDTO;
import com.be.ecommerce.entities.Shipper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ShipperMapper {

    private final ModelMapper shipperMapper;

    public ShipperMapper(){this.shipperMapper = new ModelMapper();}

    public ShipperDTO convertToDto(Shipper shipper){

        ShipperDTO shipperDTO = shipperMapper.map(shipper, ShipperDTO.class);
        return shipperDTO;

    }

    public Shipper convertToEntity(ShipperDTO shipperDTO){

        Shipper shipper = shipperMapper.map(shipperDTO, Shipper.class);
        return shipper;
    }

}
