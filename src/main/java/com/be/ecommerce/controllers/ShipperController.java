package com.be.ecommerce.controllers;


import com.be.ecommerce.dto.ShipperDTO;
import com.be.ecommerce.dto.UserDTO;
import com.be.ecommerce.entities.Shipper;
import com.be.ecommerce.entities.User;
import com.be.ecommerce.mappers.ShipperMapper;
import com.be.ecommerce.services.ShipperService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "api/v1/shippers/")
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
    public ShipperDTO getUser(@PathVariable("id") Long id){
        Shipper shipper = shipperService.getShipper(id);
        return shipperMapper.convertToDto(shipper);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateShipper(@PathVariable("id") Long id){
    }
}
