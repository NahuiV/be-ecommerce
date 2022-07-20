package com.be.ecommerce.services;

import com.be.ecommerce.constants.Constants;
import com.be.ecommerce.entities.Shipper;
import com.be.ecommerce.exceptions.shipper.ShipperExistsException;
import com.be.ecommerce.exceptions.shipper.ShipperNotFoundException;
import com.be.ecommerce.repositories.ShipperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperService {

    private final ShipperRepository shipperRepository;

    public ShipperService(ShipperRepository shipperRepository){
        this.shipperRepository = shipperRepository;
    }

    public void addShipper(Shipper shipper){
        Optional<Shipper> optionalShipper = shipperRepository.findShipperByPhone(shipper.getPhone());
        if(optionalShipper.isPresent()){
            throw new ShipperExistsException(Constants.SHIPPER_EXISTS + shipper.getPhone());
        }
    }

    public void deleteShipper(Long id){
        if(!shipperRepository.existsById(id)){
            throw  new ShipperNotFoundException(Constants.SHIPPER_NOT_FOUND + id);

        }
        shipperRepository.deleteById(id);
    }

    public Shipper getShipper(Long id){

        Optional<Shipper> shipper = shipperRepository.findById(id);
        if(!shipper.isPresent()){
            throw new ShipperNotFoundException(Constants.SHIPPER_NOT_FOUND + id);
        }
        return shipper.get();

    }

    public List<Shipper> getAllUsers(){
        return shipperRepository.findAll();
    }

}
