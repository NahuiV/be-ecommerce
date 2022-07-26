package com.be.ecommerce.controllers;


import com.be.ecommerce.dto.ShipperDTO;
import com.be.ecommerce.entities.Shipper;
import com.be.ecommerce.mappers.ShipperMapper;
import com.be.ecommerce.services.ShipperService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/api/v1/shippers/")
public class ShipperController {

    private final ShipperService shipperService;

    private final ShipperMapper shipperMapper;

    public ShipperController(ShipperService shipperService, ShipperMapper shipperMapper){

        this.shipperService = shipperService;
        this.shipperMapper = shipperMapper;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createShipper(@RequestBody ShipperDTO shipperDTO){

        Shipper shipper = shipperMapper.convertToEntity(shipperDTO);
        shipperService.addShipper(shipper);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ShipperDTO getShipper(@PathVariable("id") Long id){
        Shipper shipper = shipperService.getShipper(id);
        return shipperMapper.convertToDto(shipper);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateShipper(@PathVariable("id") Long id, @RequestBody ShipperDTO shipperDTO){

        Shipper shipper = shipperService.getShipper(id);


        shipper.setId(shipperDTO.getId());
        shipper.setCompanyName(shipperDTO.getCompanyName());
        shipper.setPhone(shipperDTO.getPhone());
        shipper.setUrl(shipperDTO.getUrl());
        shipper.setTaxes(shipper.getTaxes());
        shipper.setAddress(shipperDTO.getAddress());

        shipperService.saveShipper(shipper);

    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteShipper(@PathVariable("id") Long id){

        ShipperDTO shipperDTO = getShipper(id);
        shipperService.deleteShipper(id);

    }
}
